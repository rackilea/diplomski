public class Application {

    public void start() {

          Scanner kbd = new Scanner(System.in);

          System.out.println("Enter the first number:");
          int num1 = kbd.nextInt();

          System.out.println("Enter the second number:");
          int num2 = kbd.nextInt();

          System.out.println("Enter the three number:");
          int num3 = kbd.nextInt();

          largeSmall(num1, num2, num3);

          }



    public static void largeSmall(int one, int two, int three)
          {
          if(one > two && two > three)
          {
             System.out.println(one + " " + two + " " + three);
          }
          else if(two > one && one > three)
          {
             System.out.println(two + " " + one + " " + three);
          }
          else if(three > two && two > one)
          {
             System.out.println(three + " " + two + " " + one);
          }
          else
          {
             System.out.println(one + " " + three + " " + two);
          }



    }//end start method

}//end application class