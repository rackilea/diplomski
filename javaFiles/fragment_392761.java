File outputFile = new File("/path/to/file.txt");
Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                new FileOutputStream(outputFile), "UTF-8"));
for (long id : ids.getIDs()) {
    writer.write(id + "\n");
}
writer.close();