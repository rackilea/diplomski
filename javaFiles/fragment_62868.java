Scanner k = new Scanner(System.in);
    int length = k.nextInt();
    k.nextLine(); // get rid of lingering line terminator.
    String a = k.nextLine();
    String b = k.nextLine();

    if (a.length() != length && b.length() != length) {
        System.out.println("Inconsistent or incorrect lengths");
        return; // assumes you are in main
    }     


    String c = " ";
    String d;

    for (int i = 0; i<length; i++){
        if (a.charAt(i)==b.charAt(i)){
            d = "0";
        } else {
            d = "1";
        }
        c = c+d;
    }