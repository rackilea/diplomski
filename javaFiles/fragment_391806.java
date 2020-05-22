Scanner scanner = new Scanner(new File(inPath));
scanner.useDelimiter("Level");
while(scanner.hasNext()) {
    ++lastLevelCreatedWas;
    scanner.next();
}