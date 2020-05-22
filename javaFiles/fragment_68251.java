public void read(File file) throws IOException{
    Scanner scanner = new Scanner(file);

    while(scanner.hasNext()){
        System.out.println(scanner.nextLine());
    }
}