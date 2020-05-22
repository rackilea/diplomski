String[] array = { "010100101", "0010010" };
try {
    // write
    OutputStream os = new FileOutputStream("arun");
    for (int i = 0; i < array.length; i++) {
        os.write(array[i].getBytes(Charset.forName("UTF-8")));
    }
    // read
    InputStream is = new FileInputStream("arun");
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    String line;
    while (( line = reader.readLine() ) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.err.println("You fucked up!");
}