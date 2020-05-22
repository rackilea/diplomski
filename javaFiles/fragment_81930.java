final 
btVerify.setOnAction(
    (ActionEvent e) -> {
            LinkedList<Character> expInput = new LinkedList<Character>();
            for(char c: tfExpress.getText().toCharArray()){
                expInput.add(c);
            }

            if(card1.CardValue() == Integer.valueOf(expInput.get(0))
                 && card2.CardValue() == Integer.valueOf(expInput.get(1) )
                 && card3.CardValue() == Integer.valueOf(expInput.get(2))
                 && card4.CardValue() == Integer.valueOf(expInput.get(3))){
                 if(express == 24){
                     result.set("Correct");
                 }
                 else
                    result.set("Incorrect");

             }
             else
                 result.set("The numbers in the expression don't "
                            + "match the numbers in the set.");
         });