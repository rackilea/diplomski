Scanner scanner = new Scanner(new FileReader("marks.txt"));
TreeMap<String, TreeSet<Integer>> students = new TreeMap<>();
while (scanner.hasNextLine()) {
    String[] columns = scanner.nextLine().split("\\s+");
    String student = columns[0];
    TreeSet<Integer> set;
    if(students.containsKey(student)) {
        // A set already exists in the map for this student,
        // append to it
        set = students.get(student);
    } else {
        // No set exists in the map for this student,
        // create a new one and put it in the map
        set = new TreeSet<>();
        students.put(student, set);
    }
    set.add(Integer.parseInt(columns[1]));
}
System.out.println("Alpha Order");
// Iterate over TreeMap
for (String key : students.keySet()) {
    System.out.println(key + " :: " + String.join(", ", students.get(key)));
}