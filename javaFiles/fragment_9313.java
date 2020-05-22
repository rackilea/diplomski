SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy"); //note that mm is minutes, so you need MM here
Scanner s = new Scanner( System.in );

String dateLine = s.nextLine();
try
{
  Date d = f.parse( dateLine );
  System.out.println(d);
}
catch( ParseException e )
{
  System.out.println("please enter a valid date in format mm/dd/yyyy");
}