// Generated from D:/mohye/IdeaProjects/IAudit-Control-Swing/src/main/java/antlr\gram.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramParser}.
 */
public interface gramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(gramParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(gramParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#for_all}.
	 * @param ctx the parse tree
	 */
	void enterFor_all(gramParser.For_allContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#for_all}.
	 * @param ctx the parse tree
	 */
	void exitFor_all(gramParser.For_allContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#accept}.
	 * @param ctx the parse tree
	 */
	void enterAccept(gramParser.AcceptContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#accept}.
	 * @param ctx the parse tree
	 */
	void exitAccept(gramParser.AcceptContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#reject}.
	 * @param ctx the parse tree
	 */
	void enterReject(gramParser.RejectContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#reject}.
	 * @param ctx the parse tree
	 */
	void exitReject(gramParser.RejectContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#accept_all_but}.
	 * @param ctx the parse tree
	 */
	void enterAccept_all_but(gramParser.Accept_all_butContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#accept_all_but}.
	 * @param ctx the parse tree
	 */
	void exitAccept_all_but(gramParser.Accept_all_butContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#reject_all_but}.
	 * @param ctx the parse tree
	 */
	void enterReject_all_but(gramParser.Reject_all_butContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#reject_all_but}.
	 * @param ctx the parse tree
	 */
	void exitReject_all_but(gramParser.Reject_all_butContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(gramParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(gramParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimalExpression(gramParser.DecimalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimalExpression(gramParser.DecimalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(gramParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(gramParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(gramParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(gramParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(gramParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(gramParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(gramParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(gramParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(gramParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(gramParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparatorExpression(gramParser.ComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparatorExpression(gramParser.ComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(gramParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(gramParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(gramParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(gramParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(gramParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(gramParser.BoolContext ctx);
}