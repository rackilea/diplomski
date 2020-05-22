if(args.length !=3){
          System.out.println("Error. Must give 3 values");
        }
        else//if the above condition if true so skip these statements
        {
    try
    {
     int x = Integer.parseInt(args[0]);
     int y = Integer.parseInt(args[1]);
     int z = Integer.parseInt(args[2]);

     if((x%2)==0 && (y%2)==0 &&(z%2)==0)
     System.out.println("Even");

    else
    System.out.println("odd");
    }
    catch(NumberFormatException ne)
    {
      System.out.println("Plz! pass only integer values");//catching number format exception
    }
    }