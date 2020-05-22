public List<Integer> loadDataFor(String name) throws IOException {
    List<Integer> data = new ArrayList<>();
    try (Scanner s = new Scanner(file)) {
        while (s.hasNextLine()) {
            String[] row = s.nextLine().split("\\s+");
            if (row[0].equalsIgnoreCase(name)) {
                for (int i = 1; i < row.length; i++) {
                    data.add(Integer.parseInt(row[i]));
                }
            }
        }
    }
    return data;
}