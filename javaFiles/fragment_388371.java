public static void winner ()
{
  if (position1 >= 100){
    System.out.println(new StringBuilder("THE WINNER IS ").append(name1).toString()); 
  }
  else if (position2 >= 100){
    System.out.println(new StringBuilder("THE WINNER IS ").append(name2).toString()); 
  }
}