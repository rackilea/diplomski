Scanner scanner = new Scanner(System.in);
    int n1 = 0, n2 = 0;
    boolean bError = true;
    while (bError) {
        if (scanner.hasNextInt())
            n1 = scanner.nextInt();
        else {
            scanner.next();
            continue;
        }
        if (scanner.hasNextInt())
            n2 = scanner.nextInt();
        else {
            scanner.next();
            continue;
        }
        bError = false;
    }
    System.out.println(n1);
    System.out.println(n2);