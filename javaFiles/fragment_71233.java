public static Map<String, List<Integer>> readFile(String filename) {
    Map<String, List<Integer>> map = new HashMap<>();
    File file = new File(System.getProperty("user.home"), filename);
    try (Scanner s = new Scanner(file)) {
        while (s.hasNextLine()) {
            String[] row = s.nextLine().split("\\s+");
            List<Integer> al = new ArrayList<>();
            for (int i = 1; i < row.length; i++) {
                al.add(Integer.parseInt(row[i]));
            }
            map.put(row[0], al);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return map;
}