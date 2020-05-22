do {
    try {
       System.out.println("Enter A :");
       String numA = br.readLine();
       int a = Integer.parseInt(numA);
       break;
    } catch (Exception e /*InputMismatchException e*/) {
       System.out.println("Please fill in a number between –2,147,483,648 and 2,147,483,647");
       //System.out.println(e.printStackTrace()); //Use this to print the error
    }
} while (true);