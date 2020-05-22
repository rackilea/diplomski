%{

import java.io.*;

%}

%pure_parser

%error_verbose

%token FCONST;
%token IDENTIFIER;
%token STRING_DEFINITION;
%token ASSIGN;
%token OPEN_SQUARE_BRACKET;
%token CLOSE_SQUARE_BRACKET;
%token SPLIT;


%%

program:    FCONST IDENTIFIER ASSIGN explicit_value
       ;

explicit_value :
    OPEN_SQUARE_BRACKET const_array_list_value CLOSE_SQUARE_BRACKET
    |
    STRING_DEFINITION
    {
        System.out.printf("explicit_value %s \n", ((ParserVal)($1)).sval);
    }
    ;

const_array_list_value :
    explicit_value
    |
    const_array_list_value explicit_value
    ;