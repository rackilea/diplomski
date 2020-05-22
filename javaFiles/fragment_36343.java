public static void mjj() {
    int s = 1;
    for (int i = 1; i <= 5;i++) { // up to 5
        for (int j = 1; j <=20; j++) { // up to 20
            s++;  // <-- do it here
            if (s % 2 == 0)
                System.out.print(s + " ");
        }
        System.out.println();
    }
}