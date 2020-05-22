public class Practice {

    public static void main(String[] args) {
    System.out.println("Enter a String");
    Scanner input = new Scanner(System.in);
    String hex = "";
    StringBuilder output = new StringBuilder();
    while((hex = input.nextLine()) != "done"){
        for (int i = 0; i < hex.length(); i+=2) {
          System.out.println("Enter a String");
          String str = hex.substring(i, i+2);
            output.append((char)Integer.parseInt(str, 16));
         }
          System.out.println(output);
     }
 }