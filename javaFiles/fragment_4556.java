List<String> mixedStuff = new ArrayList<String>();
    mixedStuff.add("hello123");

    int sevens = 777;
    mixedStuff.add("alpha" + sevens);

    Integer eights = 888;
    mixedStuff.add("bravo" + eights.toString());

    Collections.sort(mixedStuff);