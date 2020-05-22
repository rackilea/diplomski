public class TPiece extends Piece {
    String[][] a = {{ "1", "2", "3" },
                    { "4", "5", "6" },
                    { "7", "8", "9" }};

    public TPiece()
    {
        setTetramino(a);
    }

    public static void main(String[] args)
    {
        TPiece T = new TPiece();
        T.print();
        T.rotate();
        T.print();
    }
}