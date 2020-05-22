public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] input = new int[10];

    for (int i = 0; i < input.length; i++) {
        int n = sc.nextInt();

        boolean loop = true;
        do {
            if (checkunique(n, input)) {
                // If true
                input[i] = n;
                loop = false;
            } else {
                // If false
                System.out.println("Choose a different one.");
                n = sc.nextInt();
            }
        } while (loop);
    }
}