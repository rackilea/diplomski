Scanner scan = new Scanner(System.in);
    String input = scan.next();
    if (input.charAt(0) == '+') {
        input = input.substring(1);
    }
    int i = Integer.parseInt(input);
    System.out.println(i);