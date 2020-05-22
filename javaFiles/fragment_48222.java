final String filename = "MHS_Baseball_Season_Stats_19_csv.txt";
List<String> lines = Files.readAllLines(Paths.get(fileName));
List<List<String>> playerStats = new ArrayList<>(lines.size());

for (String line : lines) {
    String[] lineValues = line.split(",");
    playerStats.add(Arrays.asList(lineValues));
}