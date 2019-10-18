// Generated from D:/mohye/IdeaProjects/IAudit-Control-Swing/src/main/java/antlr\gram.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(gramParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#for_all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_all(gramParser.For_allContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#accept}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccept(gramParser.AcceptContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#reject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReject(gramParser.RejectContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#accept_all_but}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccept_all_but(gramParser.Accept_all_butContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#reject_all_but}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReject_all_but(gramParser.Reject_all_butContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(gramParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalExpression(gramParser.DecimalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(gramParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(gramParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(gramParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(gramParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(gramParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link gramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparatorExpression(gramParser.ComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(gramParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#binary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(gramParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(gramParser.BoolContext ctx);
}