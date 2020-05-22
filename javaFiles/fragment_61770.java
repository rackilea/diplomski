condition  : orAtom ('||' orAtom)+ ;
orAtom     : atom ('&&' atom)+ ;
atom       : '(' condition ')'
           | expression ;
expression : value OPER value ;
value      : VARIABLE | LITERAL '
VARIABLE   : (LETTER | '_') (LETTER | DIGIT | '_')* ;
LITERAL    : NUMBER
           | STRING ;
NUMBER     : '-'? DIGIT+ ('.' DIGIT+)? ;
STRING     : '"' . CHAR* . '"' '
CHAR       : ('\\' | '\"' | .) + ;
LETTER     : 'a'..'z' | 'A'..'Z' ;
DIGIT      : '0'..'9' ;
OPER       : '>' | '>=' | '<' | '<=' | '=' | '!=' ;