Scanner scanner = new Scanner(new FileReader("marks.txt"));
TreeMultimap<String, Integer> students = TreeMultimap.create();
while (scanner.hasNextLine()) {
    String[] columns = scanner.nextLine().split("\\s+");
    students.put(columns[0], Integer.parseInt(columns[1]));
}
System.out.println("Alpha Order");
// Iterate over TreeMap
for (String key : students.keySet()) {
    System.out.println(key + " :: " + String.join(", ", students.get(key)));
}