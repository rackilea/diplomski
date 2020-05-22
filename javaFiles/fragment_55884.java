public void save(Context context, String jsonString) throws IOException {
  File rootFolder = context.getExternalFilesDir(null);
  File jsonFile = new File(rootFolder, "file.json");
  FileWriter writer = new FileWriter(jsonFile);
  writer.write(jsonString);
  writer.close();
  //or IOUtils.closeQuietly(writer);
}