StringBuilder result = new StringBuilder();
int responseCode = connection.getResponseCode();
try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
        responseCode == 200 ? connection.getInputStream() 
        : connection.getErrorStream()))) {
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        result.append(line);
    }
}
if (responseCode != 200) {
    throw new Gson().fromJson(result.toString(), FooException.class);
} else {
    return new Gson().fromJson(result.toString(), Foo.class);
}