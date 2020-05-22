public static void main(String[] args) throws IOException {
    String url="https://www.ozbargain.com.au/node/249439#comment-3719026";
    Document doc = Jsoup.connect(url).get();
    Elements comments = doc.select("div.comment-wrap");

    Matcher levelMatcher = Pattern.compile("(?i)^(.*level)(\\d+)(.*)$").matcher("");
    List<String> levels = new ArrayList<>();

    System.out.println("Comments found: "+ comments.size());

    for (Element comment : comments) {            
        if (levelMatcher.reset(comment.parent().parent().className()).find()) {
            levels.add(levelMatcher.replaceAll("$2"));
        }
    }

    System.out.println(levels);
}