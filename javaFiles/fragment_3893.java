for (int x=0; x<(AnswerCounter);x++){
                while((answer==ans[x])||(answer>30)){
                    //choose operands
                    operand1 = random.nextInt(numberList.length);
                    operand2 = random.nextInt(numberList.length);
                    answer = operand1+operand2;
                }
            }