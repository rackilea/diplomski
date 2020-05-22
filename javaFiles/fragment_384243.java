**Make the following changes in your code.Hope so it works as you wanted.**

    import java.util.Scanner;
    class Love 
    {
      public static void main (String[] args) 
      {
     // creation the scanner to look for when the enter key is pressed 


          Scanner scanner = new Scanner(System.in);
          String readString = scanner.nextLine();
         while(readString!=null)
         {
                    System.out.println(readString);

                  if (readString.isEmpty()) 
                  {

                     System.out.println("Read Enter Key");
                  }

                 if (scanner.hasNextLine()) 
                 {
                      readString = scanner.nextLine();
                      System.out.println("second hit");
                      readString=null;
                 } 


          }

     }

 }