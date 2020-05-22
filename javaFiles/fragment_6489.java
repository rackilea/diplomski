`/*Get the input*/
        String input = "5am-10am"; //Get the input

        /*Separate the first number from the second number*/
        String[] values = input.split("-"); //Returns 'values[5am, 10am]'

        /*Not the best code -- but clearly shows what to do*/
        values[0] = values[0].replaceAll("am", ""); 
        values[0] = values[0].replaceAll("pm", "");
        values[1] = values[1].replaceAll("am", "");
        values[1] = values[1].replaceAll("pm", "");

        /*Allows you to now use the string as an integer*/
        int value1 = Integer.parseInt(values[0]);
        int value2 = Integer.parseInt(values[1]);

        /*To show it works*/
        int answer = value1 + value2;
        System.out.println(answer); //Outputs: '15'`