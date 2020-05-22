ArgumentListExpression argumentListExpression = new ArgumentListExpression();
argumentListExpression.addExpression(new ConstantExpression("attrList"))
for (String attributeName : Arrays.asList("a", "b", "c"));
    argumentListExpression.addExpression(new ConstantExpression(attributeName));
classNode.addObjectInitializerStatements(new ExpressionStatement(new MethodCallExpression(
                        VariableExpression.THIS_EXPRESSION, "setProperty", argumentListExpression)));