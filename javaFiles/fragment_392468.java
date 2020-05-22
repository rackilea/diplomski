public static void getPow(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first integer: ");    // 3
    int first = sc.nextInt();
    System.out.println("Enter second integer: ");    // 2
    int second = sc.nextInt();
    System.out.println(first + " to the power of " + second + " is " + 
        (int) Math.pow(first, second));    // outputs 9