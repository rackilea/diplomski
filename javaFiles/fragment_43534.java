public abstract class Piece {
    private int y;
    private int x;
    private String[][] tetramino;

    public void setTetramino(String[][] a) { tetramino = a; }

    public void rotate()
    {
        String[][] copy = new String[3][3];
        copy[0][0] = tetramino[0][2];
        copy[0][1] = tetramino[1][2];
        copy[0][2] = tetramino[2][2];
        copy[1][0] = tetramino[0][1];
        copy[1][1] = tetramino[1][1];
        copy[1][2] = tetramino[2][1];
        copy[2][0] = tetramino[0][0];
        copy[2][1] = tetramino[1][0];
        copy[2][2] = tetramino[2][0];
        setTetramino(copy);
    }

    public void print()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(tetramino[i][j]);
            }
            System.out.println();
        }
    }
}