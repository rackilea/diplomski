grammar Exp;

options { 
  output=AST; 
}

// parser rules
parse
  :  additionExp
  ;

additionExp
  :  multiplyExp (Add^ multiplyExp)*
  ;

multiplyExp
  :  atomExp (Mult^ atomExp)* 
  ;

atomExp
  :  Number
  |  LParen! additionExp RParen!
  ;

// lexer rules
Add    : '+' ;
Mult   : '*' ;
LParen : '(' ;
RParen : ')' ;   
Number : ('0'..'9')+ ('.' ('0'..'9')+)? ;
Spaces : (' ' | '\t' | '\r'| '\n') {$channel=HIDDEN;} ;