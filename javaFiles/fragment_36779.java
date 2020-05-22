Scanner scanner = new Scanner(new File(flatFile));
scanner.useDelimiter("\r\n");
while (scanner.hasNext()) {
    String line = scanner.next();
    String cells[] = line.split("\t");                          
    System.out.println(cells.length);
    System.out.println(line);
}