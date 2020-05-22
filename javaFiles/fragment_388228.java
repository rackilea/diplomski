Scanner in = new Scanner(System.in);
char[] response = new char[20];

//Prompts User to fill array with their responses
for(int i = 0; i < response.length; i++) {
   for (;;) {
       System.out.println("Answer " + (i + 1) + ":");
       response[i] = in.nextLine().charAt(0);
       //Input validation
       if ("ABCD".indexOf(response[i]) >= 0)
           break;
       System.out.print("Please try again, it must be A, B, C or D");
   }
}