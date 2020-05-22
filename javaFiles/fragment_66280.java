public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    // change initialCapacity to reflect the likely final size
    int initialCapacity = 1024;

    StringBuilder builder = new StringBuilder(initialCapacity);

    try {
        BufferedReader reader = req.getReader();
        char [] buffer = new char[1024];

        int charsRead = 0;
        do {
            charsRead = reader.read(buffer, 0, buffer.length);
            if (charsRead > 0) {
                builder.append(buffer, 0, charsRead);
            }
        } while (charsRead != -1);
    } catch (IOException e) {
        // your error handling here
    }

    String s = builder.toString();
    Text text = new Text(s);

    // etc etc.
}