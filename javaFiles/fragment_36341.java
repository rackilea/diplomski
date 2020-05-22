public static void mjj() {
    int s = 1;
    for (int i = 1; i <=10;i++) {
        for (int j = 1; j <=10;j++) {
            s++;  // <-- do it here
            if (s % 2 == 0)
                System.out.print(s + " ");
        }
        System.out.println();
    }
}