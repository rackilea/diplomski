for (int i=h/2; i >= -(h/2); i--) {
    StringBuilder prefix = new StringBuilder("");
    // you only need one loop for the hyphens
    for (int j=1; j <= Math.abs(i); j++) {
        prefix.append("-");
    }
    System.out.print(prefix);
    // and you only need one loop for the letters
    for (int j=0; j <= 2 * ((h/2) - Math.abs(i)); j++) {
        System.out.print(c);
    }
    // ADD THIS CODE
    System.out.println(prefix);

    if (i > 0) {
        c++;
    } else {
        c--;
    }
}

public static void main(String[] args) {
    drawNumDiamond(9);
}