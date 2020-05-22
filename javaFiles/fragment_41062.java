try {
    String userName = System.getProperty("user.name");
    String command = "id -u "+userName;
    Process child = Runtime.getRuntime().exec(command);

    // Get the input stream and read from it
    InputStream in = child.getInputStream();
    int c;
    while ((c = in.read()) != -1) {
        process((char)c);
    }
    in.close();
} catch (IOException e) {
}