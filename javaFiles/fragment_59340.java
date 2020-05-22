terminal END, EXPR, EXPR1, EXPR2;
terminal OP1, OP2, OP3;

precedence OP3; 
precedence OP2;
precedence OP1_POSTFIX;  //OP1 in postfix position
precedence OP1_PREFIX;   //OP1 in prefix position

EXPR  ::= END | EXPR1 | EXPR2
EXPR1 ::= OP1_PREFIX EXPR
EXPR2 ::= EXPR OP1_POSTFIX