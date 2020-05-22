grammar i;

@header {
package i;
}

module      : 'Module1'| 'Module2';
object      : 'I';
objectType  : 'Name';
filters     : | 'WHERE' module;
table       : module object objectType filters;
STRING      : ('a'..'z'|'A'..'Z')+;
WS          : (' '|'\t'|'\f'|'\n'|'\r')+ {skip();}; //ignore whitespace