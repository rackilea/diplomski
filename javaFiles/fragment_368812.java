@Test
public void writeHashMapToCsv() throws Exception {
    Map<String, String> map = new HashMap<>();
    map.put("abc", "aabbcc");
    map.put("def", "ddeeff");

    StringWriter output = new StringWriter();
    try (ICsvListWriter listWriter = new CsvListWriter(output, 
         CsvPreference.STANDARD_PREFERENCE)){
        for (Map.Entry<String, String> entry : map.entrySet()){
            listWriter.write(entry.getKey(), entry.getValue());
        }
    }

    System.out.println(output);
}