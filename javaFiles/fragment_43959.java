grammar T;

options {
  output=AST;
}

tokens {
  ASSIGNMENT;
}

parse
  :  statement+ EOF -> statement+
  ;

statement
  :  ifStatement
  |  assignment
  ;

ifStatement
  :  IF a=expression THEN b=expression (ELSE c=expression)? -> ^(IF $a $b $c?)
  ;

assignment
  :  ID '=' expression -> ^(ASSIGNMENT ID expression)
  ;

expression
  :  orExpression
  ;

orExpression
  :  andExpression (OR^ andExpression)*
  ;

andExpression
  :  equalityExpression (AND^ equalityExpression)*
  ;

equalityExpression
  :  relationalExpression (('==' | '!=')^ relationalExpression)*
  ;

relationalExpression
  :  atom (('<=' | '<' | '>=' | '>')^ atom)*
  ;

atom
  :  BOOLEAN
  |  NUMBER
  |  ID
  |  '(' expression ')' -> expression
  ;

IF      : 'if';
THEN    : 'then';
ELSE    : 'else';
OR      : 'or';
AND     : 'and';
BOOLEAN : 'true' | 'false';
ID      : ('a'..'z' | 'A'..'Z')+;
NUMBER  : '0'..'9'+ ('.' '0'..'9'+)?;
SPACE   : (' ' | '\t' | '\r' | '\n') {skip();};