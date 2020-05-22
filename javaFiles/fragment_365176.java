// File: YaccLexer.g4
lexer grammar YaccLexer;

DECLARATION_TOKEN
 : [a-zA-Z]+
 ;

SPACES
 : [ \t\r\n]+ -> skip
 ;

DECLARATION_END
 : '%%' -> skip, pushMode(RULE_MODE)
 ;

mode RULE_MODE;

  RULE_TOKEN
   : [a-zA-Z]+
   ;

  SPACES_RULE_TOKEN
   : [ \t\r\n]+ -> skip
   ;

  RULE_END
   : '%%' -> skip, pushMode(SUBROUTINE_MODE)
   ;

mode SUBROUTINE_MODE;

  ANY
   : . -> skip
   ;