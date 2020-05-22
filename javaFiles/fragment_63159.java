fragment NameStartChar
    :       'A'..'Z' | 'a'..'z';
fragment NameChar
    :       NameStartChar
    |       Num
    |       '_'
    ;
fragment Num
    :       '0'..'9';
TYPE_NUM: 'NUM';
//All other keyword definitions ('BOOL', 'STRING' and so alike)
Identifier
    :   NameStartChar NameChar*