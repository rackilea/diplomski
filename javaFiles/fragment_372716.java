text
 : wordExp name
 ;

name
 : WORD WORD? // one ore two words
 ;

wordExp
 : PLAY
 | SEARCH
 ;

// Keywords definition _before_ the `WORD` rule!
PLAY   : 'play';
SEARCH : 'search';

WORD : ( 'a'..'z' | 'A'..'Z' )+; // digits in here?

SPACES : ( ' ' | '\t' | '\r' | '\n' )+ {skip();};