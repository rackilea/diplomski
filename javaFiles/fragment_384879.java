for (int line = 1; line <= 9; line++) {
    int firstValueInCurrentLine = 80 * line + 40;
    for (int position = 1; position <= line; position++) {
        System.out.print(firstValueInCurrentLine + 2 * (position -1) + "  ");
    }
    System.out.println();
}