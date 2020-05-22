grammar YourGrammarName;

options {
  output=AST;
}

tokens {
  ATTRIBUTES;
}

// ...

expression
 : ( simpleLookup
   | lookup
   )
   ( x=LSQRBRACKET^ {$x.setType(ATTRIBUTES);} attributesExpr RSQRBRACKET! )?
 ;

// ...