public static char[][] readBoard(InputStream in) throws IOException {
    ObjectInputStream ois = new ObjectInputStream(in);
    return (char[][]) ois.readObject();
}

public static void writeBoard(OutputStream out, char[][] board) throws IOException {
    ObjectOutputStream oos = new ObjectOutputStream(out);
    oos.writeObject(board);
}