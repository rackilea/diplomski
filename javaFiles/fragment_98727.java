final Scanner scan = new Scanner(new File("/path/to/StudentsList"));
final List<Student> students = new ArrayList<Student>();    

while (scan.hasNextLine()) {
    final Scanner line = new Scanner(scan.nextLine());
    line.useDelimiter("%");

    students.add(new Student(line.next(), line.nextInt(), line.nextInt()));

    line.close();
}
scan.close();