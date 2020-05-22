public static void main(String args[])
{
   int kidsPrice = 0;
   int studentPrice=5;
   int adultPrice=20;
   int seniorsPrice = 10;
   int numberOfKids =  0; 
   int numberOfStudents = 0;
   int numberOfAdults = 0 ;
   int numberOfSeniors = 0;

   System.out.println("Enter Age ");
   try (Scanner input = new Scanner(System.in))
   {
      while (input.hasNext())
      {
         int numbers = input.nextInt();
         if (numbers < 0)
            // TODO
         else if (numbers <= 5)
            ++numberOfKids;
         else if (numbers <= 18)
            ++numberOfStudents;
         else if (numbers <= 65)
            ++numberOfAdults;
         else
            ++numberOfSeniors;
      }
      System.out.println("Number of kids is: " + numberOfKids);
      System.out.println("Revenue from kids:  " + numberOfKids* kidsPrice);
      System.out.println("Number of Students is: " + numberOfStudents);
      System.out.println("Revenue from Students:  " + numberOfStudents * studentPrice);
      System.out.println("Number of Adults is: " + numberOfAdults);
      System.out.println("Revenue from Adults:  " + ++numberOfAdults * adultPrice);
      System.out.println("Number of Seniors is: " + numberOfSeniors);
      System.out.println("Revenue from Seniors:  " + numberOfSeniors * seniorsPrice);
   }
}