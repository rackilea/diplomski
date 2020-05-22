private final static String fileName = "Desktop/titanic.txt";

public static void main(String[] args) {
    List<String[]> list = new ArrayList<>();
    try (Scanner s1 = new Scanner(new File(System.getProperty("user.home"),
            fileName))) {
        while (s1.hasNextLine()) {
            list.add(s1.nextLine().split("\\s+"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    int pos = 0;
    String[][] data = new String[list.size()][];
    for (String[] arr : list) {
        data[pos++] = arr;
    }
    System.out.println(Arrays.deepToString(data));
}