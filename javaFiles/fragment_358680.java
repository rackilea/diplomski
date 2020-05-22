LEGAL_ESCAPE    : ESC [bfrnt"] ;
ILLEGAL_ESCAPE  : ESC 
                   ( ~[bfrnt"]  // any char not in the set
                   | EOF        // it is a non char
                   )
                ;
fragment ESC    : '\\' ;