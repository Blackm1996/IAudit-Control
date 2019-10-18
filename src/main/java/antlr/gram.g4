grammar gram;

parse : (for_all | accept | reject)? EOF;

for_all:FOR_ALL LPAREN sequence=STRING RPAREN LBRACE (sa=accept|sr=reject)? (acall=accept_all_but|reall=reject_all_but)+ RBRACE;

accept:ACCEPT LBRACE expression RBRACE;
reject:REJECT LBRACE expression RBRACE;
accept_all_but:ACCEPT_ALL_BUT LBRACE expression RBRACE;
reject_all_but:REJECT_ALL_BUT LBRACE expression RBRACE;

expression
 : LPAREN expression RPAREN                       #parenExpression
 | NOT expression                                 #notExpression
 | left=expression op=comparator right=expression #comparatorExpression
 | left=expression op=binary right=expression     #binaryExpression
 | bool                                           #boolExpression
 | STRING                                         #stringExpression
 | (old=Old|neww=New) Dot IDENTIFIER              #identifierExpression
 | DECIMAL                                        #decimalExpression
 ;

comparator
 : GT | GE | LT | LE | DIF | EQ
 ;

binary
 : AND | OR
 ;

bool
 : TRUE | FALSE
 ;

FOR_ALL        : 'For_All';
REJECT_ALL_BUT : 'Reject_All_But';
ACCEPT_ALL_BUT : 'Accept_All_But';
ACCEPT         : 'Accept';
REJECT         : 'Reject';
AND            : 'AND' ;
OR             : 'OR' ;
NOT            : '!';
TRUE           : 'TRUE' ;
FALSE          : 'FALSE' ;
GT             : '>' ;
GE             : '>=' ;
LT             : '<' ;
LE             : '<=' ;
DIF            : '!=' ;
EQ             : '==' ;
LPAREN         : '(' ;
RPAREN         : ')' ;
LBRACE         : '{' ;
RBRACE         : '}' ;
Old            : 'Old' ;
New            : 'New';
Dot            : '.' ;
STRING          : '"' (ESC | ~ ["\\])* '"'
{
    String s=getText();
    s = s.substring(1, s.length() - 1);
    setText(s);
};
fragment ESC    : '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment HEX    : [0-9a-fA-F];
DECIMAL        : '-'? [0-9]+ ( '.' [0-9]+ )? ;
IDENTIFIER     : [a-zA-Z_] [a-zA-Z_0-9]* ;
WS             : [ \r\t\u000C\n]+ -> skip;