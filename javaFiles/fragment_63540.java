main : statement+;
statement: ':' (identifier|other_words)+ CR*;
identifier : '$' IDENTIFIER;
other_words : ~(CR)+ ;

IDENTIFIER : [A-Za-z]+ ;
CR : '\r'? '\n' ;

WS : [ \t]+ -> skip ;