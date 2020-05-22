public static void main(String[] args) {
    create(3);
    int i = 0;
    do {
        for (int j = 0 ; j < 3 ; j++) {
            c[j].bet();
            c[j].display();
        }
        System.out.println();
        i++;
    } while (i < 3);
}