expr: term            { $$ = $1; /* see below */ }
    | expr '+' term   { $$ = new_sum_node($1, $3); }
term: factor          { $$ = $1; /* see below */ }
    | term '*' factor { $$ = new_product_node($1, $3); }
factor: '(' expr ')'  { $$ = $2; /* See below */ }
      | ID            { $$ = new_variable_node($1); }
      | NUMBER        { $$ = new_literal_node($1); }