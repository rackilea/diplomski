public static void main(String[] args) {

        int[] array = new int[100];
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of Questions: ");
        int n_Elements = in.nextInt();

        System.out.println("Enter the values now: ");

        for (int i = 1 ; i <= n_Elements ; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 1 ; i <= n_Elements ; i++) {
            int num = 1;
            if (array[i] == 0) {
                System.out.println("\n1");
            } else {
                for (int j = 1 ; j <= array[i] ; j++) {
                    if (j % 2 != 0) {
                        num = num * 2;
                    } else {
                        num = num + 1;
                    }
                }
                System.out.println(num);
            }
        }
    }