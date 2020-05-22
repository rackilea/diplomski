String equation = "4+ 10";
    equation.replaceAll(" ", "");//get rid if the space

    final String [] buffer = equation.split("\\+|\\*|\\-|\\/");


    if(buffer.length == 2)
    {
        int term1 = Integer.parseInt(buffer[0]);
        int term2 = Integer.parseInt(buffer[1]);

        //call you calculation  ode

    }else
        System.out.println("Fail to parse equation");