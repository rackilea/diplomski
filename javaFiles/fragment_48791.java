for (int i = 1; i < 8; i++) {
    System.out.printf("%d\t", i);
}
System.out.println();
for (int i = 1; i < 8; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.printf("%d\t", i * j);
    }
    System.out.println();
}