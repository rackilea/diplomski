tokens {
  IS_NOT; // added
  NOT_IN; // added
  QUERY;
  INDEXES;
}

query
    :   expr EOF   ->   ^(QUERY expr)
    ;

expr
    :   logical_expr
    ;

logical_expr
    :   equality_expr (logical_op^ equality_expr)*
    ;

equality_expr
    :   ID equality_op atom    -> ^(equality_op ID atom) // changed equality_op+ to equality_op
    |   '(' expr ')'    ->  ^('(' expr)
    ;

atom
    :   ID
    |   id_list
    |   Int
    |   Number
    |   String
    |   '*'
    ;

id_list
    :   '(' ID (',' ID)+ ')'    ->  ID+
    |   '(' Number (',' Number)* ')' -> Number+
    |   '(' String (',' String)* ')' -> String+
    ;

equality_op
    :   IS NOT -> IS_NOT // added
    |   NOT IN -> NOT_IN // added
    |   IN
    |   IS
    |   NOT
    ;

logical_op
    :   AND
    |   OR
    ;

IS : 'IS' | 'is'; // added
NOT : 'NOT' | 'not'; // added
IN : 'IN' | 'in'; // added
AND : 'AND' | 'and'; // added
OR : 'OR' | 'or'; // added

Number
    :   Int ('.' Digit*)?
    ;

ID
    :   ('a'..'z' | 'A'..'Z' | '_' | '.' | '-' | '*' | '/' | ':' | Digit)+ 
    ;

String
@after {
    setText(getText().substring(1, getText().length()-1).replaceAll("\\\\(.)", "$1"));
    }
    :  '"'  (~('"' | '\\')  | '\\' ('\\' | '"'))* '"' 
    |  '\'' (~('\'' | '\\') | '\\' ('\\' | '\''))* '\''
    ;

Comment
    :  '//' ~('\r' | '\n')* {skip();}
    |  '/*' .* '*/'         {skip();}
    ;

Space
    :  (' ' | '\t' | '\r' | '\n' | '\u000C') {skip();}
    ;

fragment Int
    :  '1'..'9' Digit*
    |  '0'
    ;

fragment Digit 
    :  '0'..'9'
    ;

indexes
    :  ('[' expr ']')+ -> ^(INDEXES expr+)
    ;