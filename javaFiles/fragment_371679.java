Scanner input = new Scanner(System.in);
String myString1 =  new String ("state");
String myString2 =  new String ("capitalstate");

System.out.println ("input state");
myString1=input.next(); 

if (myString1.contains("malaysia"))
   {
     myString2 = "kuala lumpur";
     System.out.println ("capital state for " +myString1+ " is " +myString2);
    }

else if (myString1.equals("south korean"))
    {
      myString2 = "seoul";
      System.out.println ("capital state for " +myString1+ " is " +myString2);
    }