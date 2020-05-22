public class expl {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String consatinate = "a";
        String needed = "apple";
        while (!consatinate.equals(needed)) {
            System.out.println("Enter a letter");
            String input = inputScanner.nextLine();
            consatinate = consatinate.concat(input);        
            System.out.println(consatinate);
        }

        inputScanner.close();
    }
}