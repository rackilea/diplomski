grammar Robot;

file    :   command+;
command :   (delay | type | move | Click | RClick) ;
delay   :   'wait' Number ';';
type    :   'type' Id ';';
move    :   'move' Number ',' Number ';';
Click   :   'click' ;
RClick  :   'rlick' ;
Id      :   ('a'..'z'|'A'..'Z')+ ;
Number  :   ('0'..'9')+ ;
WS      :   (' ' | '\t' | '\r' | '\n') { skip();} ;