InputStream input = new BufferedInputStream(connection.getInputStream());
BufferedReader reader = new BufferedReader(new InputStreamReader(input));
String line;
while ((line = br.readLine()) != null) {

    LIST.add(line);

    // further break the line into a list of comma separated values
    List<String> commaSeparatedValues = Arrays.asList(line.split(","));
}
...