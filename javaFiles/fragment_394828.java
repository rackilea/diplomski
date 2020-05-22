grammar Expression;

parse
 : expr EOF
 ;

expr
 : '(' expr ')'                          #nestedExpr
 | '-' expr                              #unartyMinusExpr
 | expr ( '*' | '/' | '%' ) expr         #multExpr
 | expr ( '+' | '-' ) expr               #addExpr
 | expr ( '>' | '>=' | '<' | '<=' ) expr #compareExpr
 | expr ( '=' | '!=' ) expr              #eqExpr
 | expr AND expr                         #andExpr
 | expr OR expr                          #orExpr
 | function_call                         #functionCallExpr
 | ID                                    #idExpr
 | NUMBER                                #numberExpr
 | STRING                                #stringExpr
 ;

function_call
 : ID args
 ;

args
 : '(' ( expr ( ',' expr )* )? ')'
 ;

ADD    : '+';
MINUS  : '-';
MULT   : '*';
DIV    : '/';
MOD    : '%';
OPAR   : '(';
CPAR   : ')';
LTE    : '<=';
LT     : '<';
GTE    : '>=';
GT     : '>';
EQ     : '=';
NEQ    : '!=';
AND    : 'and';
OR     : 'or';
NUMBER : ( [0-9]* '.' )? [0-9]+;
ID     : [a-zA-Z_] [a-zA-Z_0-9]*;
STRING : '"' ~["\r\n]* '"';
NL     : '\r'? '\n' | '\r';
SPACE  : [ \t] -> skip;