public String returnLastExpressionEvaluated(String script) {
    Parser jsParser = new Parser();
    try {
        AstRoot ast = jsParser.parse(script, "script", 1);
        ast.getType();
        ast.visitAll(new NodeVisitor() {
            @Override
            public boolean visit(AstNode node) {
                if (node.getType() == Token.EXPR_RESULT) {
                    ExpressionStatement exprNode = (ExpressionStatement) node;
                    Assignment assignmentNode = createAssignmentNode("_returnValue", exprNode.getExpression());
                    assignmentNode.setParent(exprNode);
                    exprNode.setExpression(assignmentNode);
                }
                return true;
            }
        });
        StringBuilder result = new StringBuilder();
        result.append("var _returnValue;\n");
        result.append(ast.toSource());
        result.append("return _returnValue;\n");
        return result.toString();
    } catch (Exception e) {
        logger.debug(LogUtils.format("Error parsing script"), e);
        return script;
    }
}

private Assignment createAssignmentNode(String varName, AstNode rightNode) {
    Assignment assignmentNode = new Assignment();
    assignmentNode.setType(Token.ASSIGN);
    Name leftNode = new Name();
    leftNode.setType(Token.NAME);
    leftNode.setIdentifier(varName);
    leftNode.setParent(assignmentNode);
    assignmentNode.setLeft(leftNode);
    rightNode.setParent(assignmentNode);
    assignmentNode.setRight(rightNode);
    return assignmentNode;
}