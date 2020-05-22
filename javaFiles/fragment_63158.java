fragment NameStartChar
    :       'A'..'Z' | 'a'..'z';
fragment NameChar
    :       NameStartChar
    |       Num
    |       '_'
    ;
fragment Num
    :       '0'..'9';
Identifier
    :   NameStartChar NameChar*;
TYPE_NUM: 'NUM';