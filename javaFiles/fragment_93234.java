List<List<NodeSearchResult>> xpathResultsList = new ArrayList<>();
    List<NodeSearchResult> searchResults;
    List<CSVDataLine> inputData = getCSVInputData();

    for (CSVDataLine anInputData : inputData) {
        String inputXPath = anInputData.getXPath();
        searchResults = xpathEvaluator.getXpathSearchResults(inputXPath);
        xpathResultsList.add(searchResults);
    }