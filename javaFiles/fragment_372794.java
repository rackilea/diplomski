@Test
public void test() throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // Your current Json seems to be a map with date string as a key
    // Create a corresponding type for gson to deserialize to
    // correct generic types
    Type type = new TypeToken<Map<String, Entry>>() {}.getType();
    // Check this file name for your environment
    String fileName = "src/test/java/org/example/diary/test.json";
    Reader reader = new FileReader(new File(fileName));
    // Read the whole diary to memory as java objects 
    Map<String, Entry> diary = gson.fromJson(reader, type);
    // Modify one field
    diary.get("2019-01-13").setTextfield1("modified field");
    // Add a new date entry
    Entry e = new Entry();
    e.setDate("2019-01-14");
    e.setScale(3);
    e.setTextfield1("Dear Diary");
    e.setTextfield1("I met a ...");
    diary.put(e.getDate(), e);
    // Store the new diary contents. Note that this one does not overwrite the
    // original file but appends ".out.json" to file name to preserver the original
    FileWriter fw = new FileWriter(new File(fileName + ".out.json"));
    gson.toJson(diary, fw);
    fw.close();
}