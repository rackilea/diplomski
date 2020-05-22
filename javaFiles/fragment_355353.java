final List<String[]> rows = new ArrayList<>();
try (final BufferedReader reader= new BufferedReader(new FileReader("sqlqueuery.txt")))
{
    String line;
    while ((line = reader.readLine()) != null) {
        rows.add(line.split("\\s*\\|\\s*"));
    }

} catch (final IOException e) {
    //TODO handle errors
}