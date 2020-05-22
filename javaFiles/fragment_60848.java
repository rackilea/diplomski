LetLangExpr parseProgram(LinkedList<String> tokens) {
  return parseExpression(tokens);
}

LetLangExpr parseExpression(LinkedList<String> tokens) {
  if ("-".equals(tokenStream.peekFirst())) {
    return parseDiff(tokens);
  } else {
    return parseNumber(tokens);
  }
}

LetLangExpr parseDiff(LinkedList<String> tokens) {
  tokens.pollFirst();  // Consume "-"
  LetLangExpr left = parseExpression(tokens);
  LetLangExpr right = parseExpression(tokens);
  return new DiffExpr(left, right);
}

LetLangExpr parseNumber(LinkedList<String> tokens) {
  String numberStr = tokens.pollFirs();
  double number = Double.parseDouble(numberStr);
  return new NumberExpr(number);
}