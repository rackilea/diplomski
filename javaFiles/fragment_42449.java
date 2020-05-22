String equation = "4+ 10";
    equation.replaceAll(" ", "");//get rid if the space

    String[] buffer = null;
    if (equation.contains("+"))
        buffer = equation.split("\\+");
    else if (equation.contains("*"))
        buffer = equation.split("\\*");
    else if (equation.contains("/"))
        buffer = equation.split("\\/");
    else if (equation.contains("-"))
        buffer = equation.split("\\-");


    if(buffer != null && buffer.length == 2)
    {
        int term1 = Integer.parseInt(buffer[0]);
        int term2 = Integer.parseInt(buffer[1]);

        //call you calculation  ode

    }else
        System.out.println("Fail to parse equation");