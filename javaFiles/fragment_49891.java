String format="MM/dd/yyyy";

Scanner sc=new Scanner(System.in);
String input=sc.nextLine();//now the program waits for input
Date d= new SimpleDateFormat("MM/dd/yyyy").parse("12/10/1994");
Calendar cal=Calendar.getInstance();
cal.setTime(d);

String output=new SimpleDateFormat(format).format(cal.getTime());