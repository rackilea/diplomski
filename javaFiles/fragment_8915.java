ArgumentListExpression argumentListExpression = new ArgumentListExpression();
for (String attributeName : Arrays.asList("a", "b", "c"))
    argumentListExpression.addExpression(new ConstantExpression(attributeName));
classNode.addObjectInitializerStatements(new ExpressionStatement(new MethodCallExpression(
                        VariableExpression.THIS_EXPRESSION, "setProperty",
                        new ArgumentListExpression(new ConstantExpression("attrList"), argumentListExpression))));