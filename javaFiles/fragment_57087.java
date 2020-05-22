int counter = 1;
for (int i = 1; i <= 4; ++i) {
    for (int j = 1; j <= i; ++j) {
        System.out.print(counter++);
        System.out.print(" ");
    }
    System.out.println();
}