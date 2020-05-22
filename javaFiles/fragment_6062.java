VariableResolverFactory myVarFactory = new MapVariableResolverFactory();
myVarFactory.setNextFactory(functionFactory);

Serializable s = MVEL.compileExpression("foo(); bar();");

MVEL.executeExpression(s, myVarFactory);