class ScannerWrapper implements Iterable<E> {
    public Scanner scanner;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public Iterator<String> iterator() {
        return scanner;
    }
} 

Scanner scanner = new Scanner("one,two,three");
scanner.useDelimiter(",");
ScannerWrapper wrapper = new ScannerWrapper(scanner);

for(String s : wrapper) {
    System.out.println(s);
}