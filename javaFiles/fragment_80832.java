interface Expression {
    public int interpret(Map<String,Expression> variables);
}

class Number implements Expression {
    private int number;
    public Number(int number)       { this.number = number; }
    public int interpret(Map<String,Expression> variables)  { return number; }
}

class Plus implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Plus(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return leftOperand.interpret(variables) + rightOperand.interpret(variables);
    }
}

class Minus implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Minus(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return leftOperand.interpret(variables) - rightOperand.interpret(variables);
    }
}
class Times implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Times(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return leftOperand.interpret(variables) * rightOperand.interpret(variables);
    }
} 

class Division implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Division(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return leftOperand.interpret(variables) / rightOperand.interpret(variables);
    }
}

class IfThen implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public IfThen(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return (leftOperand.interpret(variables)==1) ? rightOperand.interpret(variables) : 0;
    }
}

class GreaterThan implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public GreaterThan(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return (leftOperand.interpret(variables) > rightOperand.interpret(variables)) ? 1 : 0;
    }
}

class GreaterThanOrEqual implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public GreaterThanOrEqual(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return (leftOperand.interpret(variables) >= rightOperand.interpret(variables)) ? 1 : 0;
    }
}
class LessThan implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public LessThan(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return (leftOperand.interpret(variables) < rightOperand.interpret(variables)) ? 1 : 0;
    }
}

class LessThanOrEqual implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public LessThanOrEqual(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return (leftOperand.interpret(variables) <= rightOperand.interpret(variables)) ? 1 : 0;
    }
}

class Equal implements Expression {
    Expression leftOperand;
    Expression rightOperand;
    public Equal(Expression left, Expression right) { 
        leftOperand = left; 
        rightOperand = right;
    }

    public int interpret(Map<String,Expression> variables)  { 
        return (leftOperand.interpret(variables) == rightOperand.interpret(variables)) ? 1 : 0;
    }
}
class Variable implements Expression {
    private String name;
    public Variable(String name)       { this.name = name; }
    public int interpret(Map<String,Expression> variables)  { 
        if(null==variables.get(name)) return 0; //Either return new Number(0).
        return variables.get(name).interpret(variables); 
    }
}
class Evaluator implements Expression {
    private Expression syntaxTree;

    public Evaluator(String expression) {
        Stack<Expression> expressionStack = new Stack<Expression>();
        for (String token : expression.split(" ")) {
            if  (token.equals("+")) {
                Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                expressionStack.push( subExpression );
            }
            else if (token.equals("-")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new Minus(left, right);
                expressionStack.push( subExpression );
            }
            else if  (token.equals("*")) {
                Expression subExpression = new Times(expressionStack.pop(), expressionStack.pop());
                expressionStack.push( subExpression );
            }
            else if  (token.equals("/")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new Division(left, right);
                expressionStack.push( subExpression );
            }
            else if  (token.equals("if-then")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new IfThen(left, right);
                expressionStack.push( subExpression );
            }
            else if  (token.equals(">")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new GreaterThan(left, right);
                expressionStack.push( subExpression );
            }
            else if  (token.equals(">=")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new GreaterThanOrEqual(left, right);
                expressionStack.push( subExpression );
            }
            else if  (token.equals("<")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new LessThan(left, right);
                expressionStack.push( subExpression );
            }
            else if  (token.equals("<=")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new LessThanOrEqual(left, right);
                expressionStack.push( subExpression );
            }
            else if  (token.equals("==")) {
                // it's necessary remove first the right operand from the stack
                Expression right = expressionStack.pop();
                // ..and after the left one
                Expression left = expressionStack.pop();
                Expression subExpression = new Equal(left, right);
                expressionStack.push( subExpression );
            }
            else                        
                expressionStack.push( new Variable(token) );
        }
        syntaxTree = expressionStack.pop();
    }

    public int interpret(Map<String,Expression> context) {
        return syntaxTree.interpret(context);
    }
}