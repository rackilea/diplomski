Path filePath = Paths.get("file.txt");
Scanner scanner = new Scanner(filePath);
List<Integer> integers = new ArrayList<>();

while (scanner.hasNext()) {
    if (scanner.hasNextInt()) {
        integers.add(scanner.nextInt());
    } else {
        scanner.next();
    }
}