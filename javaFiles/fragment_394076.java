new ActionListener() {

    public void actionPerformed(ActionEvent e) {

        String  output2= "Number format error";
        try{
            int num1 = Integer.parseInt(Num1.getText().trim());


            int num2 = Integer.parseInt(Num2.getText().trim());

            int result = num1 / num2;

            Result.setText(String.valueOf(result));
            //continueInput = false;

        } catch (){// parse exception
            // popup dialog for format error
        } catch (){// divide by 0
            // popup dialog for ArithmeticException
        }
    } 
}