for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i; j++) {
            System.out.print(" ");
        }
        boolean b = true;
        for (int k = 0; k < i * 2 + 1; k++) {
            if (b) {
                System.out.print("*");
                b = false;
            } else {
                System.out.print(" ");
                b = true;
            }
        }
    }
    System.out.println(" "); // called only once

    // output is
    //   *  * * * * *