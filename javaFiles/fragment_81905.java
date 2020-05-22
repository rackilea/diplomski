public Main() throws IOException {
    throw new IOException();
}

public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    Main.class.newInstance(); // throws IOException silently.
}