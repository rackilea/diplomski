File directory = new File("/home/jon/somewhere");
File fullPath = new File(directory, fileName);
BufferedWriter writer = new BufferedWriter(
    new OutputStreamWriter(
        (new FileOutputStream(fullPath), charSet));
try {
    writer.write("\n");
    writer.write("work");
} finally {
    writer.close();
}