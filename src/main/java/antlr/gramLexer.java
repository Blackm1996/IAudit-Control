// Generated from D:/mohye/IdeaProjects/IAudit-Control-Swing/src/main/java/antlr\gram.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR_ALL=1, REJECT_ALL_BUT=2, ACCEPT_ALL_BUT=3, ACCEPT=4, REJECT=5, AND=6, 
		OR=7, NOT=8, TRUE=9, FALSE=10, GT=11, GE=12, LT=13, LE=14, DIF=15, EQ=16, 
		LPAREN=17, RPAREN=18, LBRACE=19, RBRACE=20, Old=21, New=22, Dot=23, STRING=24, 
		DECIMAL=25, IDENTIFIER=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FOR_ALL", "REJECT_ALL_BUT", "ACCEPT_ALL_BUT", "ACCEPT", "REJECT", "AND", 
			"OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "DIF", "EQ", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "Old", "New", "Dot", "STRING", "ESC", "UNICODE", 
			"HEX", "DECIMAL", "IDENTIFIER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'For_All'", "'Reject_All_But'", "'Accept_All_But'", "'Accept'", 
			"'Reject'", "'AND'", "'OR'", "'!'", "'TRUE'", "'FALSE'", "'>'", "'>='", 
			"'<'", "'<='", "'!='", "'=='", "'('", "')'", "'{'", "'}'", "'Old'", "'New'", 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FOR_ALL", "REJECT_ALL_BUT", "ACCEPT_ALL_BUT", "ACCEPT", "REJECT", 
			"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "DIF", "EQ", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "Old", "New", "Dot", "STRING", 
			"DECIMAL", "IDENTIFIER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public gramLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 23:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    String s=getText();
			    s = s.substring(1, s.length() - 1);
			    setText(s);

			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00df\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\7\31\u00ad\n\31\f\31"+
		"\16\31\u00b0\13\31\3\31\3\31\3\31\3\32\3\32\3\32\5\32\u00b8\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\5\35\u00c3\n\35\3\35\6\35\u00c6"+
		"\n\35\r\35\16\35\u00c7\3\35\3\35\6\35\u00cc\n\35\r\35\16\35\u00cd\5\35"+
		"\u00d0\n\35\3\36\3\36\7\36\u00d4\n\36\f\36\16\36\u00d7\13\36\3\37\6\37"+
		"\u00da\n\37\r\37\16\37\u00db\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\2\65\2\67\29\33;\34=\35\3\2\t\4\2$$^^\n\2$$\61\61"+
		"^^ddhhppttvv\5\2\62;CHch\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\16"+
		"\17\"\"\2\u00e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2"+
		"\2\5G\3\2\2\2\7V\3\2\2\2\te\3\2\2\2\13l\3\2\2\2\rs\3\2\2\2\17w\3\2\2\2"+
		"\21z\3\2\2\2\23|\3\2\2\2\25\u0081\3\2\2\2\27\u0087\3\2\2\2\31\u0089\3"+
		"\2\2\2\33\u008c\3\2\2\2\35\u008e\3\2\2\2\37\u0091\3\2\2\2!\u0094\3\2\2"+
		"\2#\u0097\3\2\2\2%\u0099\3\2\2\2\'\u009b\3\2\2\2)\u009d\3\2\2\2+\u009f"+
		"\3\2\2\2-\u00a3\3\2\2\2/\u00a7\3\2\2\2\61\u00a9\3\2\2\2\63\u00b4\3\2\2"+
		"\2\65\u00b9\3\2\2\2\67\u00bf\3\2\2\29\u00c2\3\2\2\2;\u00d1\3\2\2\2=\u00d9"+
		"\3\2\2\2?@\7H\2\2@A\7q\2\2AB\7t\2\2BC\7a\2\2CD\7C\2\2DE\7n\2\2EF\7n\2"+
		"\2F\4\3\2\2\2GH\7T\2\2HI\7g\2\2IJ\7l\2\2JK\7g\2\2KL\7e\2\2LM\7v\2\2MN"+
		"\7a\2\2NO\7C\2\2OP\7n\2\2PQ\7n\2\2QR\7a\2\2RS\7D\2\2ST\7w\2\2TU\7v\2\2"+
		"U\6\3\2\2\2VW\7C\2\2WX\7e\2\2XY\7e\2\2YZ\7g\2\2Z[\7r\2\2[\\\7v\2\2\\]"+
		"\7a\2\2]^\7C\2\2^_\7n\2\2_`\7n\2\2`a\7a\2\2ab\7D\2\2bc\7w\2\2cd\7v\2\2"+
		"d\b\3\2\2\2ef\7C\2\2fg\7e\2\2gh\7e\2\2hi\7g\2\2ij\7r\2\2jk\7v\2\2k\n\3"+
		"\2\2\2lm\7T\2\2mn\7g\2\2no\7l\2\2op\7g\2\2pq\7e\2\2qr\7v\2\2r\f\3\2\2"+
		"\2st\7C\2\2tu\7P\2\2uv\7F\2\2v\16\3\2\2\2wx\7Q\2\2xy\7T\2\2y\20\3\2\2"+
		"\2z{\7#\2\2{\22\3\2\2\2|}\7V\2\2}~\7T\2\2~\177\7W\2\2\177\u0080\7G\2\2"+
		"\u0080\24\3\2\2\2\u0081\u0082\7H\2\2\u0082\u0083\7C\2\2\u0083\u0084\7"+
		"N\2\2\u0084\u0085\7U\2\2\u0085\u0086\7G\2\2\u0086\26\3\2\2\2\u0087\u0088"+
		"\7@\2\2\u0088\30\3\2\2\2\u0089\u008a\7@\2\2\u008a\u008b\7?\2\2\u008b\32"+
		"\3\2\2\2\u008c\u008d\7>\2\2\u008d\34\3\2\2\2\u008e\u008f\7>\2\2\u008f"+
		"\u0090\7?\2\2\u0090\36\3\2\2\2\u0091\u0092\7#\2\2\u0092\u0093\7?\2\2\u0093"+
		" \3\2\2\2\u0094\u0095\7?\2\2\u0095\u0096\7?\2\2\u0096\"\3\2\2\2\u0097"+
		"\u0098\7*\2\2\u0098$\3\2\2\2\u0099\u009a\7+\2\2\u009a&\3\2\2\2\u009b\u009c"+
		"\7}\2\2\u009c(\3\2\2\2\u009d\u009e\7\177\2\2\u009e*\3\2\2\2\u009f\u00a0"+
		"\7Q\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7f\2\2\u00a2,\3\2\2\2\u00a3\u00a4"+
		"\7P\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7y\2\2\u00a6.\3\2\2\2\u00a7\u00a8"+
		"\7\60\2\2\u00a8\60\3\2\2\2\u00a9\u00ae\7$\2\2\u00aa\u00ad\5\63\32\2\u00ab"+
		"\u00ad\n\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\7$\2\2\u00b2\u00b3\b\31\2\2\u00b3\62\3\2\2"+
		"\2\u00b4\u00b7\7^\2\2\u00b5\u00b8\t\3\2\2\u00b6\u00b8\5\65\33\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\64\3\2\2\2\u00b9\u00ba\7w\2\2"+
		"\u00ba\u00bb\5\67\34\2\u00bb\u00bc\5\67\34\2\u00bc\u00bd\5\67\34\2\u00bd"+
		"\u00be\5\67\34\2\u00be\66\3\2\2\2\u00bf\u00c0\t\4\2\2\u00c08\3\2\2\2\u00c1"+
		"\u00c3\7/\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2"+
		"\2\2\u00c4\u00c6\t\5\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cf\3\2\2\2\u00c9\u00cb\7\60"+
		"\2\2\u00ca\u00cc\t\5\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00c9\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0:\3\2\2\2\u00d1\u00d5\t\6\2\2\u00d2\u00d4"+
		"\t\7\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6<\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00da\t\b\2\2"+
		"\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b\37\3\2\u00de>\3\2\2\2\f\2\u00ac"+
		"\u00ae\u00b7\u00c2\u00c7\u00cd\u00cf\u00d5\u00db\4\3\31\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}