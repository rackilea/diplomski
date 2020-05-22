public List<Expression> visit(AndExpression andExpression) {
    List<Expression> list = new ArrayList<Expression>();
    lex = andExpression.getLeftExpression();
    list.add(lex);
    rex = andExpression.getRightExpression();
    subEx1 = rex.getLeftExpression();
    subEx2 = rex.getRightExpression();
    list.add(subEx1);
    list.add(subEx2);
    return list;
}