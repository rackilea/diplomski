grammar T;

// parser rules

// lexer rules

/* last lexer rules */
FALL_THROUGH
  :  .  {throw new RuntimeException("Illegal character: " + getText());}
  ;