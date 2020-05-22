public static void main(final String[] args) throws FileNotFoundException {
    ArrayList<String> animal = new ArrayList<>();
    animal.add("Dog");
    animal.add("Cat");
    animal.add("Mouse");

    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 15; i++) {
        numbers.add(i);
    }

    PrintWriter writer = new PrintWriter("animals.csv");

    List<String> row = new ArrayList<>();
    int i = 0;
    for (String ani : animal) {
        row.add(ani);
        for (int j = 0; j < 5; j++) {
            row.add(String.valueOf(numbers.get(i++)));
        }
        writer.println(String.join(",", row));
        row.clear();
    }

    writer.close();
}