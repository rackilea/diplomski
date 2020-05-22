grammar Bookings;

bookingsFile
  :  Project Prj String String Time Hyphen Time OpenParen CloseParen EOF
  ;

Project
  :  'project'
  ;

Prj
  :  'prj'
  ;

OpenParen
  :  '{'
  ;

CloseParen
  :  '}'
  ;

Hyphen
  :  '-'
  ;

String
  :  '"' ~'"'* '"'
  ;

Time
  :  D D D D '-' D D '-' D D '-' D D ':' D D '-+' D D D D
  ;  

fragment    
D
  :  '0'..'9'
  ;

Space   
  :  (' ' | '\t' | '\r'? '\n'){$channel=HIDDEN;}
  ;