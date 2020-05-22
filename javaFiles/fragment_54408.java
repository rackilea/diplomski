switch(op){
             case "+":answer = num1 + num2;break;
             case "-":answer = num1 - num2;break;
             case "*":answer = num1 * num2;break;
             case "/":answer = num1 / num2;break;
             default: throw new IllegalArgumentException("Invalid operation "+ op);
             }
             System.out.println(answer);