AdRequest adRequest = new AdRequest();
    String[] keywords = getResources().getStringArray(R.array.key_words);
    Set<String> set = new HashSet<String>();
    int count = 0;
    while (count < keywords.length) {
        set.add(keywords[count]);
        count++;
    }
    adRequest.addKeywords(set);
    adView.loadAd(adRequest);