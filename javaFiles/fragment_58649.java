public static void main(String[] args) {
        int[] nmberchck = new int[51];
        int[] numbs = new int[15];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 15 numbers that are between 0 and 50 ");
        System.out.println();
        for (int i = 0; i < 15; i++) {
            numbs[i] = sc.nextInt();
        }
        for (int i = 0; i < 15; i++) {
            if (!(numbs[i] < 0 || numbs[i] > 50))
                nmberchck[numbs[i]]++;
        }

        for (int i = 0; i < nmberchck.length; i++)
            if (nmberchck[i] > 0)
                System.out.println(i + " occured " + nmberchck[i]
                        + " times");
    }