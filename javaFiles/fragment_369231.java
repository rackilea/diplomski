while (p < height) {
    // print line with width i
    while (i < width) {
        // print without ln
        System.out.print("*");
        i++;
    }
    // completed a line, then reset i
    i = 0;
    // next line
    System.out.println();
    p++;
}