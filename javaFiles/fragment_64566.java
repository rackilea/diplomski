class Main2
    {
        public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        newUser(input); 
      //input.close()
    }
    private static void newUser(Scanner input) 
    {
        try {
            System.out.print("Please enter the name for the new user.");
            String userNameNew = input.nextLine();
            System.out.println("Please enter the password for the new user.");
            String userPassWordNew = input.nextLine();
            System.out.println("The new user: " + userNameNew + " has the password: " + userPassWordNew + "." );
            PrintWriter out = new PrintWriter("users.txt");
            out.print(userNameNew + "\r\n" + userPassWordNew);
            out.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}