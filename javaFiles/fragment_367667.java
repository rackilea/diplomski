functionCall returns [TLNode node]
  :  ^(FUNC_CALL Identifier exprList?)     {node = new FunctionCallNode($Identifier.text, $exprList.e, functions);}
  |  ^(FUNC_CALL Println expression?)      {node = new PrintlnNode($expression.node);}
  |  ^(FUNC_CALL Print expression)         {node = new PrintNode($expression.node);}
  |  ^(FUNC_CALL Assert expression)        {node = new AssertNode($expression.node);}
  |  ^(FUNC_CALL Size expression)          {node = new SizeNode($expression.node);}
  |  ^(FUNC_CALL Math Identifier exprList) {node = new MathCallNode($Identifier.text, $exprList.e);} // added
  ;