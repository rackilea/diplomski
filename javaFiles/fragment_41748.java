int levels = 4;
int z = 0; // this make it easy
for (int i = 0; i < levels; i++) {
    for (int s = levels; s > i; s--) {
        System.out.print(" ");
    }
    for (int j = 0; j <= i; j++) {

        System.out.print(z + " ");
        z++;
    }
    System.out.println("");
}