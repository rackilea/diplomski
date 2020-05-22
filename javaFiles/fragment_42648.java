public class ShoutBox {

    public static void shoutOutCannedMessage(List<String> list) {
       System.out.println("This is a list of options: ");
       int size = list.size();

       for(int i=0; i<size; i++)
       {
           System.out.println(list.get(i));
       }

       int userNumber;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Please enter number: ");
       userNumber = scanner.nextInt();
       System.out.println(list.get(userNumber));


   }

}