try {
    FileOutputStream fos = new FileOutputStream("test.txt");
    Writer out = new OutputStreamWriter(fos, "UTF8");
    out.write(str);
    out.close();
} catch (IOException e) {
    e.printStackTrace();
}