public void read(File file) throws IOException{
    Scanner scanner = new Scanner(file);

    while(scanner.hasNext()){
        String[] tokens = scanner.nextLine().split(";");
        String last = tokens[tokens.length - 1];
        System.out.println(last);
    }
}