
import org.antlr.v4.runtime.*;

public class InlineRecognitionException extends RecognitionException {

    public InlineRecognitionException(String message, Recognizer<?, ?> recognizer, IntStream input, ParserRuleContext ctx, Token offendingToken) {
        super(message, recognizer, input, ctx);
        this.setOffendingToken(offendingToken);
    }
}