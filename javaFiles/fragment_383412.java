Scanner sc = new Scanner(System.in);
    System.out.println(" Enter odd number above 0 here: ");
    int h = sc.nextInt();
    char x = '#';

    if (h % 2 != 0) {
        for (int i = 1; i < 2*h; i++) {

            int a = Math.abs(h-i);
            // loop for first part of hourglass
            for (int j = a; j < h; j++) {
                System.out.print(x);
            }
            // create white space
            for (int j = 0; j <a; j++) {
                System.out.print("  ");
            }
            for (int j = a; j < h; j++) {
                System.out.print(x);
            }

            System.out.println();
        }
    } else {
        System.out.println(" Not an odd number. Try again: ");
    }