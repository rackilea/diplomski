Scanner sc=new Scanner(System.in);
try
{
  System.out.println("Please input an integer");
  //nextInt will throw InputMismatchException
  //if the next token does not match the Integer
  //regular expression, or is out of range
  int usrInput=sc.nextInt();
}
catch(InputMismatchException exception)
{
  //Print "This is not an integer"
  //when user put other than integer
  System.out.println("This is not an integer");
}