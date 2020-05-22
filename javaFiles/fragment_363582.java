String str = "110001 commercial 500000.00 101";
Scanner scanner = new Scanner(str);
scanner.useDelimiter("[0-9. ]");

while (scanner.hasNext()) {
    System.out.print("*" + scanner.next() + "*-");
}