int i = 0;
    String fileName = "C:\\Users\\J Urguby\\Documents"
            + "\\NetBeansProjects\\UserPassPageScanner\\src\\userpasspagescanner\\userPass.txt";
    File file = new File(fileName);
    while (i == 0) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your user name plz:");
        String user = keyboard.next();
        System.out.println("Enter your password plz");
        String pass = keyboard.next();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split(" ");
                if (line[0].equals(user) && line[1].equals(pass)) {
                    System.out.print("Welcome");
                    i = 1;
                } 
           }
             if(i==0) System.out.println("Password or Username is incorrect");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}