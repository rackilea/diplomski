private FunctionCall getFunctionCall() {
        FunctionCall functionCall = new FunctionCall();
        Name name =  new Name();
        name.setIdentifier("initialize");
        functionCall.setTarget(name);
        StringLiteral arg = new StringLiteral();
        arg.setValue("value");
        arg.setQuoteCharacter('"');
        functionCall.addArgument(arg);
        return functionCall;
}

class FunctionVisitor implements NodeVisitor {
        @Override
        public boolean visit(AstNode node) {
             if (node.getClass() == FunctionNode.class) {
                FunctionNode fun = (FunctionNode) node;
                if(fun.getName().equals("initialize")) //prevents infinit loop
                {
                     return true;
                }
                fun.getBody().addChildrenToFront(new EmptyStatement()); // adds ';', I don't know if required
                fun.getBody().addChildrenToFront(getFunctionCall());//no fun.addChildrenToFront
            }
            return true;
        }

    }