grammar PropLogic;

prog
  :  formula EOF
  ;

formula 
  :  NOT formula
  |  OP formula (AND formula CP | OR formula CP | IMPLIES formula CP)
  |  SYMBOLS
  ;

NOT : '!' ;
OR  : '+' ;
AND : '.' ;
IMPLIES : '->' ;
SYMBOLS : ('a'..'z') | '~' ;
OP : '(' ;
CP : ')' ;
WHITESPACE : ('\t' | ' ' | '\r' | '\n'| '\u000C')+ { $channel = HIDDEN; } ;