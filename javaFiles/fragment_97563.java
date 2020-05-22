public static void main(String[]args){
        Scanner inp = new Scanner(System.in);
        boolean tryAgain = true;
        do{
        System.out.print("\nInput username: ");
        String user = inp.nextLine();
        System.out.print("\nInput password: ");
        String pass = inp.nextLine();
    if(user.equals("admin") && pass.equals("admin")){
            System.out.print("Success!");
            tryAgain = false;
        }
        if(!user.equals("admin") || !(pass.equals("admin")){
            JOptionPane.showMessageDialog(null, "Try again! Invalid username or password!","Error Logging-In", JOptionPane.ERROR_MESSAGE);
        tryAgain = true;
    }
}while(tryAgain);
        }
    }