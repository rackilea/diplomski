// ...

options {
  output=AST;
}

// ...

@parser::members{
  private void log(ParserRuleReturnScope rule) {
    System.out.println("Rule: "    + rule.getClass().getName() +  
                       ", start: " + rule.start +
                       ", end: "   + rule.stop);
  }
}

expr: multExpr (('+'|'-') multExpr)*    {log(retval);}
    ;

multExpr
    : atom('*' atom)*                   {log(retval);}
    ;

atom: INT
    | ID                                {log(retval);}
    | '(' expr ')'
    ;
// ...