public String getString(String resourceName) throws IOException {

BufferedReader reader = null;
StringBuilder sb = new StringBuilder();
String line;

try {
        InputStream createTableInputStream reader.getResourceAsStream(resourceName);
    reader = new BufferedReader(new InputStreamReader(is));

    while ((line = reader.readLine()) != null) {
        sb.append(line + System.lineSeparator());
    }

} catch (IOException ex) {
    ex.printStackTrace();
}
return sb.toString();
}