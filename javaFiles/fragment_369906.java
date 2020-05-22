try (BufferedReader br = new BufferedReader(new FileReader("F:/DataBase.txt"))) {
    String line;
    while((line = br.readLine())!=null ) {
        String[] values = line.split("\\s+");
        ...
    }
}