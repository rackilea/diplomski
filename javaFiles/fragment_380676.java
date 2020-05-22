File file = new File("/test.txt");
FileWriter writer = null;
try {
    writer = new FileWriter(file);
    writer.write("test");
} finally {
    if (writer != null) writer.close();
}
Desktop.getDesktop().open(file);