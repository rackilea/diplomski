import java.util.Scanner;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.PrintWriter;

    public class ReactionAnalysis {
      public static void main (String [] args) throws FileNotFoundException
      {
        int numberChoice = 0;
    //loop everything
    while (numberChoice != 5)
    {
        /// Menu Screen
    System.out.println("What would you like to do?");
    System.out.println("1: Get the score of a word");
    System.out.println("2: Get the average score of words in a file (one word per line)");
    System.out.println("3: Find the highest/lowest scoring words in a file");
    System.out.println("4: Sort words from a file into positive.txt and negative.txt");
    System.out.println("5: Exit the program");

    Scanner in = new Scanner(System.in);
    System.out.println("Enter a number 1-5");
    numberChoice = in.nextInt();
    ////

      if (numberChoice == 1)
      {
        String methodOne = methodOne();
        System.out.println(methodOne);
      }
      else if (numberChoice == 2)
      {
        String methodTwo = methodTwo();
        System.out.println(methodTwo);
      }
      else if (numberChoice == 3)
      {
        String methodThree = methodThree();
        System.out.println(methodThree);
      }
      else if (numberChoice == 4)
      {
        String methodFour = methodFour();
        System.out.println(methodFour);
      }
    }
}
}