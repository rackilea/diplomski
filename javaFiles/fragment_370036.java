FileWriter writer = null;
try {
    writer = new FileWriter("SomeoutputFile.txt", false);
    ta.write(writer);
} catch (IOException exp) {
    exp.printStackTrace();
} finally {
    try {
        writer.close();
    } catch (Exception e) {
    }
}