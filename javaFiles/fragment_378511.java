Pattern p = Pattern.compile("^#N(\\d*).\\s+(\\d*)(.+)\\s+-\\s+(\\d*)(.+)");
    Matcher m = p.matcher(s);
    m.find();
    int gameNumber = Integer.valueOf(m.group(1));
    int gamerScore = Integer.valueOf(m.group(2));
    int casinoScore = Integer.valueOf(m.group(4));
    boolean casinoWon = casinoScore - gamerScore > 0;
    Set<Card> gamerDeck  = parseDeck(m.group(3));
    Set<Card> casinoDeck = parseDeck(m.group(5));