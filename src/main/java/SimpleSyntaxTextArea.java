import antlr.gramBaseVisitor;
import antlr.gramLexer;
import antlr.gramParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.fife.ui.autocomplete.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleSyntaxTextArea extends JTextPane
{
    Condition owner;
    CompletionProvider provider;
    AutoCompletion ac;
    MyDialog dialog;
    public SimpleSyntaxTextArea(Condition owner)
    {
        super();
        this.owner=owner;
        ini();
    }

    private void ini()
    {
        dialog=new MyDialog(owner.error);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                super.mouseEntered(mouseEvent);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                super.mouseExited(mouseEvent);
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                super.mouseMoved(mouseEvent);
            }
        });
        setFont(getFont().deriveFont(16f));
        provider = createCompletionProvider();
        ac = new AutoCompletion(provider);

        /*DefaultCaret caret=(DefaultCaret)getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);*/
        ac.install(this);
        ac.setAutoActivationEnabled(true);
        ac.setAutoActivationDelay(20);
        DefaultStyledDocument doc=new DefaultStyledDocument();
        setDocument(doc);
        doc.addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent documentEvent) {
                removeMyHighlight();
                checkSyntax(documentEvent.getDocument());
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                removeMyHighlight();
                checkSyntax(documentEvent.getDocument());
            }

            public void changedUpdate(DocumentEvent documentEvent) {
            }

        });
    }

    private void checkSyntax(Document doc)
    {
        String s=null;
        try {
            s=doc.getText(0,doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        CollectionErrorListener listener=new CollectionErrorListener();
        gramLexer lexer = new gramLexer(CharStreams.fromString(s));
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);
        gramParser parser = new gramParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
        gramBaseVisitor extractor = new gramBaseVisitor();
        extractor.visit(parser.parse());

        dialog.clear();
        owner.changeError(listener.getErrors().size()!=0);
        for (SyntaxError e : listener.getErrors()) {
            int startPos,endPos;
            if (e.getOffendingState()==-1)
            {
                dialog.addError(e.getMessage());
                startPos=endPos=e.getInputStream().index();

            }
            else
            {
                dialog.addError(RecognitionExceptionUtil.formatVerbose(e));
                startPos=e.getOffendingToken().getStartIndex();
                endPos=e.getOffendingToken().getStopIndex()>=startPos? e.getOffendingToken().getStopIndex():startPos;
            }

           /* System.out.println("ERROR "+startPos+" "+endPos);*/
            //System.out.println(e.getMessage());
            //int length=e.getOffendingToken().getStopIndex()-e.getOffendingToken().getStartIndex();
            MyHighlightPainter painter=new MyHighlightPainter(Color.RED.brighter());
            try {
                getHighlighter().addHighlight(startPos,endPos+1,painter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }


        }
    }
    private CompletionProvider createCompletionProvider() {

        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        // Add completions for all Java keywords. A BasicCompletion is just
        // a straightforward word completion.
        provider.addCompletion(new ShorthandCompletion(provider,"For_All", "For_All (\" \") {\n\t}"));
        provider.addCompletion(new ShorthandCompletion(provider,"Reject_All_But","Reject_All_But {\n\t}"));
        provider.addCompletion(new ShorthandCompletion(provider,"Accept_All_But", "Accept_All_But {\n\t}"));
        provider.addCompletion(new ShorthandCompletion(provider,"Accept", "Accept {\n\t}"));
        provider.addCompletion(new ShorthandCompletion(provider,"Reject", "Reject {\n\t}"));
        provider.addCompletion(new ShorthandCompletion(provider, "and","AND "));
        provider.addCompletion(new ShorthandCompletion(provider, "or","OR "));
        provider.addCompletion(new VariableCompletion(provider, "TRUE",""));
        provider.addCompletion(new VariableCompletion(provider, "FALSE",""));
        provider.addCompletion(new ShorthandCompletion(provider,"Old", "Old."));
        provider.addCompletion(new ShorthandCompletion(provider,"New", "New."));
        provider.addCompletion(new VariableCompletion(provider, "timeStamp","TimeStamp"));
        provider.addCompletion(new VariableCompletion(provider, "actor","String"));
        provider.addCompletion(new VariableCompletion(provider, "action","String"));
        provider.addCompletion(new VariableCompletion(provider, "db_name","String"));
        provider.addCompletion(new VariableCompletion(provider, "table_name","String"));
        provider.addCompletion(new VariableCompletion(provider, "id_record","int"));
        provider.addCompletion(new VariableCompletion(provider, "extra","String"));


        return provider;

    }

    private class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter
    {

        public MyHighlightPainter(Color color) {
            super(color);
        }
    }

    private void removeMyHighlight()
    {
        Highlighter.Highlight[] highlighters= getHighlighter().getHighlights();

        for (Highlighter.Highlight h:highlighters)
            getHighlighter().removeHighlight(h);
    }
}
