public static void main(String[] args) throws IOException{
    List<String> allLines = Files.readAllLines(Paths.get("C:/Test/test.txt"), Charset.defaultCharset());
    Map<String,Integer> charCount = new HashMap<String,Integer>();
    for(String line:allLines){
        String[] characters = line.split(" ");
        for(String charac:characters){
            Integer currentCount = charCount.get(charac);
            charCount.put(charac, currentCount == null ? 1 : currentCount + 1); 
        }
    }
    System.out.println(charCount);
}