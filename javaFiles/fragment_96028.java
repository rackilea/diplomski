grammar Fruit;

@parser::members { 

    private StringBuilder output = new StringBuilder();
    private java.util.HashMap<String, String> colors = new java.util.HashMap<String, String>();

    public void addColor(String fruit, String color){
        colors.put(fruit, color);
    }

    private void printColor(String fruit){
        if (colors.containsKey(fruit)){
            output.append(colors.get(fruit));
            output.append(" ");
        } else { 
            output.append("(no color for ").append(fruit).append(")");
        }
    }

    private void printColor(Token id){
        printColor(id.getText());
    }

    private void evaluateCondition(java.util.List<Token> tokens){
        for (Token token : tokens){
            String fruit = token.getText();
            if (colors.containsKey(fruit)){
                printColor(fruit);
                break;
            }
        }
    }
}

conditionalString returns [String result]
@after { result = output.toString();}
            : expr
            ;

expr        : cond_expr+
            ;

cond_expr   : ID
            {printColor($ID);}
            | LSQB values+=ID (OR values+=ID)* RSQB
            {evaluateCondition($values);}
            ;

OR          : '|';
LSQB        : '[';
RSQB        : ']';
ID          : ('A'..'Z')+;
WS          : ('\t'|' ')+ {skip();};