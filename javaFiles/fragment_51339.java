char[][] in = new char[][] {
    new char[] { '#', '#', '#', '~' },
    new char[] { '~', '#', '~', '~' },
    new char[] { '~', '#', '~', '~' },
    new char[] { '~', '~', '~', '~' },
    new char[] { '~', '~', '~', '~' }
};

for (char[] line : mirror(4, 5, in)) {
    for (char row : line) {
        System.out.print(row);
    }
    System.out.println();
}