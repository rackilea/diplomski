@Param( { "1.xml", "10.xml", "100.xml" } )
String file;

private String jsonData;

@Setup
public void setup() {
    jsonData = getContent(file);
}

@Benchmark
public void jacksonDeserializeStreamTest(Blackhole bh) throws IOException {
    bh.consume(objectMapper.readValue(jsonData, Cat.class));
}

private static String getContent(String fileName) {
    try {
        InputStream stream = PersonGenerator.class.getClassLoader().getResourceAsStream(fileName);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = stream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}