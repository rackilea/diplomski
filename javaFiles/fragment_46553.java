String test = " one, ,two three,4,";
    //replace all digit to blank
    test = test.replaceAll("\\d+", "");
    List<String> splittedText = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(test);
    String combineWords = "";
    for (String word : splittedText) {
        combineWords+=word+" ";
    }

    List<String> finalSplittedWord = Splitter.on(" ").omitEmptyStrings().splitToList(combineWords);
    for (String word : finalSplittedWord) {
        System.out.println(word);
    }