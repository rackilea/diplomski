public void doPost(HttpServletRequest req, HttpServletResponse resp) {
    // change initialCapacity to reflect the likely final size
    int initialCapacity = 1024;
    StringBuilder builder = new StringBuilder(initialCapacity);

    try {
        BufferedReader reader = req.getReader();
        int c;

        while((c = reader.read()) != -1) {
            builder.append(c);
        }
    } catch (IOException e) {
        // your error handling here
    }

    String s = builder.toString();
    Text text = new Text(s);

    // etc etc.
}