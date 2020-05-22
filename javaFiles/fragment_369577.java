ClassLoader classloader = Thread.currentThread().getContextClassLoader();
InputStream is = classloader.getResourceAsStream("sample.txt");

InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
BufferedReader reader = new BufferedReader(streamReader);
try {
    for (String line; (line = reader.readLine()) != null;) {
        System.out.println(line);
    }
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}