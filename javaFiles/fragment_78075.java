public static void main(String[] args) {
    String str = "Hello World!\nHello Java!";

    // create a new scanner with the specified String Object
    Scanner scanner = new Scanner(str);

    while(scanner.hasNext()){
        System.out.println( scanner.nextLine());
    }
    scanner.close();
}