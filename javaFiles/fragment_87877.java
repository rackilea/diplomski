TregexPattern tPattern = TregexPattern.compile("NP");
while ((line = br.readLine()) != null) {
    Tree t = Tree.valueOf(line);
    TregexMatcher tMatcher = tPattern.matcher(t);
    while (tMatcher.find()) {
      System.out.println(tMatcher.getMatch());
    }
}