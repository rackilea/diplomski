Scanner in = new Scanner(System.in);

    System.out.println("Enter the first integer: ");

    int x = in.nextInt();
    System.out.println("x = " + x);
    System.out.println("Enter the second integer: ");
    int y = in.nextInt();
    System.out.println("y = " + y);

    while (x != 0) {
        if (x >= y) {
           int a = Math.max(x, y);
           int b = Math.min(x, y);
           a = a - b;
           x = a;
           y = b;
        }else if (x<y){

           int a = Math.min(x, y);
           int b = Math.max(x, y);
           b = b - a;
           x = a;
           y = b;
        }
    }

    System.out.println("The gcd =" + y);


  }

}