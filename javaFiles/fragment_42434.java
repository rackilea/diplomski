data1 will always be string, One way to check type is:

        //assuming data1 = 12.12
        String data1 = "12.12";

                boolean isInt;
                try{
                    System.out.println(Integer.parseInt(data1));
                    isInt = true;
                }catch(NumberFormatException n1){
                    isInt = false;
                }

                boolean isDouble;
                try{
                    System.out.println(Double.parseDouble(data1));
                    isDouble = true;
                }catch(NumberFormatException n2){
                    isDouble = false;
                }

    Now if you want to check if its a double then use flag -- isDouble, it should be true, or if you want to check if its a number then OR of these two flag should be true: isDouble || isInt ==> true

   //Checking if received data1 is double and valid number then 
    if(!isInt && isDouble)
        {
            double x = Double.parseDouble(data1);
            System.out.println(Math.ceil(x));
            System.out.println(Math.floor(x));
        }
    else if(isInt)
        {
            System.out.println("received int, do nothing");
        }