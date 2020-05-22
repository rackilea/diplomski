for (int i = 11; i < 32; i++) {
    int a = i * i;
    int b = i % 10;
    int c = i / 10;
    if ((a / 10 % 10) == c && (a % 10) == b) {
    //---------------------------^
        System.out.println(a);
    }
}