Scanner scn = new Scanner(System.in);
    String in = scn.nextLine();
    String time="";
    if(in.length()<=3)//23 or 234
    {
        time += in+":00";
    }
    else//23:34 or 00:32
    {
        time += in;
    }
    System.out.println(time);