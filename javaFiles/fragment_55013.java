Scanner scanner = new Scanner(new File("CSV.csv"));
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if (line.isEmpty()) {
        continue;
    }
    String[] parts = line.split(",");
    String name = parts[1];
    String number = parts[2];
    String email = parts[3];
    String address = parts[4];
    switch (parts[0]) {
    case "Faculty":
        String department = parts[5];
        String papers = parts[6];
        // add to list
        break;
    case "Student":
        String roll = parts[5];
        String gpa = parts[6];
        // add to list
        break;
    case "Staff":
        String department = parts[5];
        String salary = parts[6];
        // add to list
        break;
    }
}