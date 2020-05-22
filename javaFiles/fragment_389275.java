File file = new File("test.txt");
FileOutputStream fs = new FileOutputStream(file);
OutputStreamWriter ow = new OutputStreamWriter(fs);
BufferedWriter writer = new BufferedWriter(ow);

fs.close();

try {
    ow.write(65);
    writer.write("test");
    writer.flush();
} catch (Exception e) {
    e.printStackTrace();
}