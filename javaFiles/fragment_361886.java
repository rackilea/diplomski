String input = "yasar\0yasar"; // test input. Input will have null character in it.
byte[] compressed = new byte[100];  // hold compressed content

Deflater compresser = new Deflater();
compresser.setInput(input.getBytes());
compresser.finish();
int length = compresser.deflate(compressed);
File test_file = new File(System.getProperty("user.dir"), "test_file");
try {
    if (!test_file.exists()) {
        test_file.createNewFile();
    }
    try (FileOutputStream fos = new FileOutputStream(test_file)) {
        fos.write(compressed, 0, length); // starting at 0th byte - lenght(-1)
    }
} catch (IOException e) {
    e.printStackTrace();
}