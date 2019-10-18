import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

import java.util.Collections;
import java.util.List;

public class RecognitionExceptionUtil {

    /*public static String formatVerbose(RecognitionException e) {
        return String.format("ERROR on line %s:%s => %s%nrule stack: %s%noffending token %s => %s%n%s",
                getLineNumberString(e),
                getCharPositionInLineString(e),
                e.getMessage(),
                getRuleStackString(e),
                getOffendingTokenString(e),
                getOffendingTokenVerboseString(e),
                getErrorLineStringUnderlined(e).replaceAll("(?m)^|$", "|"));
    }*/
    public static String formatVerbose(RecognitionException e) {
        return String.format("ERROR on line %s:%s => %s%noffending token: %n%s",
                getLineNumberString(e),
                getCharPositionInLineString(e),
                e.getMessage().replace("'<EOF>'","at the end"),
                getErrorLineStringUnderlined(e).replaceAll("(?m)^|$", "|"));
    }

    public static String getRuleStackString(RecognitionException e) {
        if (e == null || e.getRecognizer() == null
                || e.getCtx() == null
                || e.getRecognizer().getRuleNames() == null) {
            return "";
        }
        List<String> stack = ((Parser)e.getRecognizer()).getRuleInvocationStack(e.getCtx());
        Collections.reverse(stack);
        return stack.toString();
    }

    public static String getLineNumberString(RecognitionException e) {
        if (e == null || e.getOffendingToken() == null) {
            return "";
        }
        return String.format("%d", e.getOffendingToken().getLine());
    }

    public static String getCharPositionInLineString(RecognitionException e) {
        if (e == null || e.getOffendingToken() == null) {
            return "";
        }
        return String.format("%d", e.getOffendingToken().getCharPositionInLine());
    }

    public static String getOffendingTokenString(RecognitionException e) {
        if (e == null || e.getOffendingToken() == null) {
            return "";
        }
        return e.getOffendingToken().toString();
    }

    public static String getOffendingTokenVerboseString(RecognitionException e) {
        if (e == null || e.getOffendingToken() == null) {
            return "";
        }
        return String.format("at tokenStream[%d], inputString[%d..%d] = '%s', tokenType<%d> = %s, on line %d, character %d",
                e.getOffendingToken().getTokenIndex(),
                e.getOffendingToken().getStartIndex(),
                e.getOffendingToken().getStopIndex(),
                e.getOffendingToken().getText(),
                e.getOffendingToken().getType(),
                e.getRecognizer().getVocabulary().getDisplayName(e.getOffendingToken().getType()),
                e.getOffendingToken().getLine(),
                e.getOffendingToken().getCharPositionInLine());
    }

    public static String getErrorLineString(RecognitionException e) {
        if (e == null || e.getRecognizer() == null
                || e.getRecognizer().getInputStream() == null
                || e.getOffendingToken() == null) {
            return "";
        }
        CommonTokenStream tokens =
                (CommonTokenStream)e.getRecognizer().getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split(String.format("\r?\n"));
        return lines[e.getOffendingToken().getLine() - 1];
    }

    public static String getErrorLineStringUnderlined(RecognitionException e) {
        String errorLine = getErrorLineString(e);
        if (errorLine.isEmpty()) {
            return errorLine;
        }
        // replace tabs with single space so that charPositionInLine gives us the
        // column to start underlining.
        errorLine = errorLine.replaceAll("\t", " ");
        StringBuilder underLine = new StringBuilder(String.format("%" + errorLine.length() + "s", ""));
        int start = e.getOffendingToken().getStartIndex();
        int stop = e.getOffendingToken().getStopIndex();
        if ( start>=0 && stop>=0 ) {
            for (int i=0; i<=(stop-start); i++) {
                underLine.setCharAt(e.getOffendingToken().getCharPositionInLine() + i, '^');
            }
        }
        return String.format("%s%n%s", errorLine, underLine);
    }
}