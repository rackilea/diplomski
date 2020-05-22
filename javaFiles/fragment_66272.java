final Path path = FileSystems.getDefault().getPath("src/main/resources/csvfile");
final List<String> lines = Files.readAllLines(path);

final String[][] arrays = new String[lines.size()][];
for (int i = 0; i < lines.size(); i++) {
    arrays[i] = lines.get(i).split(",");
}