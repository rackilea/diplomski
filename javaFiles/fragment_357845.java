Scanner scanner = new Scanner(reader);
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if (line.startsWith("HEADING_ONE")) {
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt(); 
            // do something with int
            // skip to next line
            scanner.nextLine();
        }
    } else if (line.startsWith("HEADING_TWO")) {
        while... // The same as above
    }
}