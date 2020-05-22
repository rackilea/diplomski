grammar T;

options {
  output=AST;
}

tokens {
  BLOCKS;
  BLOCK;
  TIME_RANGE;
  LINES;
  LINE;
  WORD;
}

parse
 : LineBreak* blocks LineBreak* EOF -> blocks
 ;

blocks
 : block (LineBreak LineBreak+ block)* -> ^(BLOCKS block+)
 ;

block 
 : Number Spaces? LineBreak time_range LineBreak text_lines -> ^(BLOCK Number time_range text_lines)
 ;

time_range
 : Time Spaces? Arrow Spaces? Time Spaces? -> ^(TIME_RANGE Time Time)
 ;

text_lines
 : line (LineBreak line)* -> ^(LINES line+)
 ;

line
 : Spaces? word (Spaces word)* Spaces? -> ^(LINE word+)
 ;

word
 : (Other | Number | Dashes | Arrow)+ -> WORD[$text]
 ;

Time      : Number ':' Number ':' Number ',' Number;
Arrow     : '-->';
Dashes    : '-'+;
Number    : '0'..'9'+;
LineBreak : '\r'? '\n' | '\r';
Spaces    : (' ' | '\t')+;
Other     : . ;