public Client(String[] data) throws IOException {
    connectToServer();
    for (String line : data) {
        out.println(line + "\n");
    }
}