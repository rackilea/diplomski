public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int e = Integer.parseInt(args[1]);
        for (int a = 1; a <= n; a++) {
            System.out.print("Hello World");
            for (int b = 1; b <= e; b++) {
                System.out.print("!");
            }
        e--;
        System.out.println();
        }
    }