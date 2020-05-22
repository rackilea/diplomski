functionCall
  :  Identifier '(' exprList? ')'         -> ^(FUNC_CALL Identifier exprList?)
  |  Println '(' expression? ')'          -> ^(FUNC_CALL Println expression?)
  |  Print '(' expression ')'             -> ^(FUNC_CALL Print expression)
  |  Assert '(' expression ')'            -> ^(FUNC_CALL Assert expression)
  |  Size '(' expression ')'              -> ^(FUNC_CALL Size expression)
  |  Math '.' Identifier '(' exprList ')' -> ^(FUNC_CALL Math Identifier exprList) // added
  ;

// ...

Math : 'Math'; // added