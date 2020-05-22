private StringBuffer populateStringWithUnmatchingWords(ArrayList<String>unmatchingWordsHolder) {
    StringBuffer unMatchingWordsStr = new StringBuffer();

    for (Entry<String, String> entry : wordMap.entrySet()) {
        if(unmatchingWordsHolder.contains(entry.getValue())) {
            //out.println(matchingWords.get(m)+" : "+true);
            unMatchingWordsStr.append(entry.getKey());
            unMatchingWordsStr.append(",");      
        }
    }
    return unMatchingWordsStr;
}