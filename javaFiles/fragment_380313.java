stack.push(lhs);
    while(stack.get(stack.size()-1) instanceof OrExpression || stack.get(stack.size()-1) instanceof AndExpression){

        BinaryCommonExpression popValue = (BinaryCommonExpression)stack.pop();

        try{
            if(stack.get(stack.size()-2) instanceof OrExpression || stack.get(stack.size()-2) instanceof AndExpression){
                String operatorAfter = (String)stack.pop();
                BinaryCommonExpression popVal2 = (BinaryCommonExpression)stack.pop();
                BinaryCommonExpression lhs2 = (BinaryCommonExpression)popVal2.getLHS();
                BinaryCommonExpression rhs = (BinaryCommonExpression)popVal2.getRHS();
                stack.push(lhs2);
                if(popVal2 instanceof OrExpression){
                    stack.push("OR");
                }else if (popVal2 instanceof AndExpression){
                    stack.push("And");
                }
                stack.push(rhs);
                stack.push(operatorAfter);
            }
            } catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        BinaryCommonExpression lhs2 = (BinaryCommonExpression)popValue.getLHS();
        BinaryCommonExpression rhs = (BinaryCommonExpression)popValue.getRHS();
        stack.push(lhs2);
        if(popValue instanceof OrExpression){
            stack.push("OR");
        }else if (popValue instanceof AndExpression){
            stack.push("And");
        }
        stack.push(rhs);
    }