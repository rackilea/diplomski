int numStars = 4;
String star = "*";
for (int i = 0; i < numStars; i++) {
    if (i != 0)
        System.out.println();
    for (int j = 0; j < numStars; j++) {
        if (j != 0)
            System.out.print(' ');
        System.out.print(star);
    }
}