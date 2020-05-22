grammar Example;

prog    : addExpr EOF;
addExpr : INT PLUS INT;
ID      : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
INT     : '0'..'9'+;
PLUS    : '+';