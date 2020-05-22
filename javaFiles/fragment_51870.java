public class ScannerTry {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("Enter with values: ");
    List<String> entries = new ArrayList<>();
    while(scanner.hasNext()){
        String symbol = scanner.next();
        if(symbol.equals("exit")){
            break;
        }
        entries.add(symbol);
    }
    System.out.println(entries);
}
}