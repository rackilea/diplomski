msg: msg ( COMMA message
         | XOR msg
         | PERCENT IDENTIFIER
         )
   | ( IDENTIFIER
     | IDENTIFIER LBRACKET msg RBRACKET
     | LBRACE msg RBRACE LBRACE atom RBRACE
     | IDENTIFIER PERCENT msg
     | LBRACKET msg RBRACKET
     )
   ;