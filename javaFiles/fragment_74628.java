long number2 = 0;
        try{
            number2 = Long.parseLong(output.getText());
        }catch (NumberFormatException nfe){
            System.out.println("Invalid value provided for second value");
        }
        output.setText(String.valueOf(model.calculate(number1, number2, operator)));