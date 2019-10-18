import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class MyDialog extends JDialog
{
    JTextPane area;
    JScrollPane pane;
    JComponent owner;
    public MyDialog(JComponent owner)
    {
        this.owner=owner;
        setLocationRelativeTo(owner);
        area=new JTextPane();
        pane=new JScrollPane(area);
        area.setEditable(false);

        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Times New Roman");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        aset=sc.addAttribute(aset, StyleConstants.FontSize,18);
        area.setCharacterAttributes(aset, false);

        add(pane);
        setAlwaysOnTop(true);
        //setUndecorated(true);
        //setMaximumSize(new Dimension(owner.getSize().width/2,owner.getSize().height/2));
        setMaximumSize(new Dimension(500,450));
        setMinimumSize(new Dimension(100,50));
        setPreferredSize(new Dimension(250,150));
        setSize(pane.getSize());
        pack();
        this.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {
            }
            public void windowLostFocus(WindowEvent e) {
                if (e.getOppositeWindow()!=null&&SwingUtilities.isDescendingFrom(e.getOppositeWindow(), MyDialog.this)) {
                    return;
                }
                MyDialog.this.setVisible(false);
            }
        });
    }

    @Override
    public void setVisible(boolean b)
    {
        setLocation(owner.getLocationOnScreen().x+owner.getSize().width,owner.getLocationOnScreen().y+owner.getSize().height);
        super.setVisible(b);
    }
    public MyDialog(JComponent owner, String initial)
    {
        this.owner=owner;
        setLocationRelativeTo(owner);
        area.setText(initial);
        pane=new JScrollPane(area);
        area.setEditable(false);
        add(pane);
        setAlwaysOnTop(true);
        //setUndecorated(true);
        //setMaximumSize(new Dimension(owner.getSize().width/2,owner.getSize().height/2));
        setMaximumSize(new Dimension(500,450));
        setMinimumSize(new Dimension(100,50));
        setPreferredSize(new Dimension(250,150));
        setSize(pane.getSize());
        pack();
        this.addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {
            }
            public void windowLostFocus(WindowEvent e) {
                if (e.getOppositeWindow()!=null&&SwingUtilities.isDescendingFrom(e.getOppositeWindow(), MyDialog.this)) {
                    return;
                }
                MyDialog.this.setVisible(false);
            }
        });
    }

    public void addError(String error)
    {
        if (is_Empty())
            area.setText("> "+error);
        else
            area.setText(area.getText()+"\n\n> "+error);
    }

    public boolean is_Empty()
    {
        return area.getText().isEmpty();
    }

    public boolean clear()
    {
        area.setText("");
        return area.getText().isEmpty();
    }
}
