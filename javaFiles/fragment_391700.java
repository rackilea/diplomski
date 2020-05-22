COMMENT
    : '/*' .*? '*/' -> channel(COMMENTS)
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> channel(COMMENTS)
    ;