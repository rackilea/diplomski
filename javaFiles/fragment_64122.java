public static void translator(int c, int f, boolean[][] fl) {
    System.out.println("Customer Number " + c + "    Flight Plan " + f);

    int[] coo = new int[5];
    int a = 10000;

    for (int x = 0; x < coo.length; x++) {
        coo[x] = (f / a) % 10;
        a /= 10;    
    }

    for (int x = 0; x < coo.length - 1; x++) {
        int p = coo[x]; 
        int q = coo[x + 1];

        if (fl[p][q]) {
            System.out.print(p + "\t" + q + "\tAvailable");

            if (x == coo.length - 2) {
                System.out.print("\tFlight Plan is Valid");
            }

            System.out.println();
        }
        else {
            System.out.println(p + "\t" + q + "\tUnavailable\tFlight Plan is Invalid");
            break;
        }
    }
}