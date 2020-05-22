public static void main(String[] args) {
    String str = "Hello World! Hello Java!";

    // create a new scanner with the specified String Object
    Scanner scanner = new Scanner(str);

    while(scanner.hasNext()){
        System.out.println( scanner.next());
    }
    scanner.close();
}