public static List<String> readTweets(File file) throws IOException {
    List<String> tweets = new ArrayList<String>();
    List<String> lines = Files.readAllLines(file.toPath());
    for(int i = 0; i < lines.length(); i++){
        String line = lines.get(i);
        String[] part = line.split(",");
        if(part.length < 1) tweets.add(part[i]);
   }
}