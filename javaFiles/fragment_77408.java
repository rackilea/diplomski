Scanner scanner = new Scanner(new FileReader("C:\\Path\\boards.txt"));
List<String> lines = new ArrayList<String>();
while (scanner.hasNextLine()) {
    String columns = scanner.nextLine();
    lines.add(columns);
}