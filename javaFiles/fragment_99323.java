string sourceTextForContext(ParseTree context) {
  Token startToken = (context.start instanceof TerminalNode) ? (TerminalNode)(start).getSymbol() : (ParserRuleContext)(start).start;
  Token stopToken = (context.stop instanceof TerminalNode) ? (TerminalNode)(stop).getSymbol() : (ParserRuleContext)(stop).start;

  CharStream cs = start.getTokenSource().getInputStream();
  int stopIndex = stop != null ? stop.getStopIndex() : -1;
  return cs.getText(new Interval(start.getStartIndex(), stopIndex));
}