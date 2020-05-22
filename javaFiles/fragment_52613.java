for (ParseTreeMatch match : formulaMatches) {
  ParserRuleContext formulaContext = (FormulaContext)match.get("formula");
  int quantifierCount = 0;
  for (int i = 0; i < formulaContext.getChildCount(); i++) {
    if (formulaContext.getChild(i) instanceof RuleNode
        && ((RuleNode)formulaContext.getChild(i)).getRuleContext().getRuleIndex()
            == RULE_quantifier)
    {
      quantifierCount++;
    }
  }

  // quantifierCount is accurate here...
}