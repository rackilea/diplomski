class Test {
    public static void main(String[] args) {
        char[][] table = new char[3][3];
        for (int row = 0; row < 3; row ++)
            for (int col = 0; col < 3; col++)
                table[row][col] = (char) ('1' + row * 3 + col);

        for (int row = 0; row < 3; row ++)
            for (int col = 0; col < 3; col++)
                System.out.println (table[row][col]);
    }
}