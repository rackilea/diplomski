grammar wft;

@header {
    package com.mycompany.wftdiff.parser;
}

@lexer::header {
    package com.mycompany.wftdiff.parser;
}

@members {
}

wftFile :   (COMMENT|assignment|definition|flow)*
    ;

assignment
    :   ID EQ STRING
    ;

definition
    :   'DEFINE' ID
        (COMMENT | (dclass ID type) | definition)* 
        'END' ID
    ;


dclass  :   'KEY' | 'BASE' | 'TRANS'
    ;

type    :   tnum | tvarchar | tref | tdate
    ;

tnum    :   'NUMBER'
    ;

tvarchar:   'VARCHAR2' '(' INT ')'
    ;

tref    :   'REFERENCES' ID
    ;

tdate   :   'DATE'
    ;

flow    :   'BEGIN' ID (STRING)+
        (COMMENT|assignment|flow)+
        'END' ID
    ;

EQ  :   '='
    ;

ID  :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;


NL  :   '\r'? '\n' {$channel=HIDDEN;}
    ;

COMMENT
    :   '#' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

INT :   '0'..'9'+
    ;