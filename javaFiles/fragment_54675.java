grammar T;

@parser::members {
  boolean skipParens = true;
}

example
 : {skipParens}? IDENTIFIER
 |               '(' IDENTIFIER ')'
 ;

IDENTIFIER
 : [a-z]+
 ;