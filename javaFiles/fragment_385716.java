grammar T;

options {
  output=AST;
}

tokens {
  BLOCK;
  CALL;
  PARAMS;
}

// parser rules
parse
 : block EOF!
 ;

block
 : stat* -> ^(BLOCK stat*)
 ;

stat
 : for_stat
 | if_stat
 | func_call
 ;

for_stat
 : FOR^ ID expr expr block END!
 ;

if_stat
 : IF^ expr block END!
 ;

expr
 : eq_expr
 ;

eq_expr
 : atom (('==' | '!=')^ atom)*
 ;

atom
 : func_call
 | INT
 | ID
 | STR
 ;

func_call
 : ID '(' params ')' -> ^(CALL ID params)
 ;

params
 : (expr (',' expr)*)? -> ^(PARAMS expr*)
 ;

// lexer rules
FOR : 'for';
END : 'end';
IF  : 'if';
ID  : ('a'..'z' | 'A'..'Z')+;
INT : '0'..'9'+;
STR : '\'' ~('\'')* '\'';
SP  : (' ' | '\t' | '\r' | '\n')+ {skip();};