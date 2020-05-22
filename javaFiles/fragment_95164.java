Scanner scan = new Scanner(System.in);
    System.out.println(" Input first password ");
    String pass1 = scan.nextLine();
    System.out.println(" input second password ");
    String pass2 = scan.nextLine();
    // problematic part here.
    String spass;
    if (pass1.length() > pass2.length()) {
        spass = pass2;
    } else if (pass1.length() < pass2.length()) {
        spass = pass1;
    } else {
        spass = null;
    }
    System.out.println("result: " + spass);