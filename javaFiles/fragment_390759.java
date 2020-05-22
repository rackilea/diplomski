Whitespace
    :   [ \t]+
//        -> skip
        -> channel(HIDDEN)
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
//        -> skip
        -> channel(HIDDEN)
    ;