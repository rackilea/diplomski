Employee[] employees = new Employee[10];
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {

  for (int i = 0; i < 3; i++) {
    String line = reader.readLine();
    String[] parts = line.split(" ");
    employees[i] = new PermanentStudent(parts[0], parts[1], parts[2])
  }

  for (int i = 3; i < 10; i++) {
    String line = reader.readLine();
    String[] parts = line.split(" ");
    employees[i] = new CasualStudent(parts[0], parts[1], parts[2])
  }
}