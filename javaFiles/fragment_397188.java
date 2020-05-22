public class WordCount {

   public static void main (String[]args) {
      final String SENTINEL = "END";
      int count = 0;
      Scanner sc = new Scanner(System.in);
      String text = "xy";

   do {
         if(text.endsWith("im"))
            count++;

         System.out.print("Type a text or type "+SENTINEL+" when you are done. ");
         text = sc.nextLine();

   } while(!text.equalsIgnoreCase(SENTINEL));

   System.out.println("You have typed "+ count +" texts that end in \"im\" ");
   }
}