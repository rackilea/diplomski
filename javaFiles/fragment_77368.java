String sNumberByUser = numberbyUser.getText().toString();
    Double number = 0.0;

    try{
        if(!sNumberByUser.equals("")){
            // This will accept decimal and non-decimal number
            number = Double.parseDouble(sNumberByUser);

            //do your process here

        }else{
            throw new NumberFormatException();
        }

    //Catch if not a number.
    }catch(NumberFormatException nfe){
        message = "Please Enter a Number !!";
        DialogFunction();
    }