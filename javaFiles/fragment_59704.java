public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        int n2 = input.nextInt();
        input.nextLine();
        int[][] n4 = new int[n2][2];

        for (int i = 0; i < n2; i++) {
            String string2 = input.nextLine();
            String[] s2 = string2.split(" ");
            for (int j = 0; j < 2; j++) {
                n4[i][j] = Integer.parseInt(s2[j]);
            }
        }
        for (int i = 0; i < n2; i++) {
            for (int j = n4[i][0]; j <= n4[i][1]; j++) {
                if (isPrimeNumber(j)) {
                    System.out.println(j);
                }

            }
            System.out.println();
        }

    }


    public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}