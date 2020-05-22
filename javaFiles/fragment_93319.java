public class Test {

    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);
        int n=keyboard.nextInt();

        String userResponse;
        while(true) {
            userResponse = keyboard.nextLine();
            if(userResponse.length() == 1 && userResponse.charAt(0) == 'y') {
                System.out.println("Great! Let's get started.");
                break;
            }
            else if(userResponse.length() == 1 && userResponse.charAt(0) == 'n') {
                System.out.println("Come back next time " + "" + ".");
                System.exit(0);
            }
            else {
                System.out.println("Invalid response.");
            }
        }
    }

}