public static void main(String[] args) {
    ArrayList<String> inputXpaths = new ArrayList<>();
    inputXpaths.add("/Return/ReturnData/Person/Name");

    XpathEvaluator evaluator = new XpathEvaluator();
    evaluator.loadFile("src/test/resources/xml/input.xml");
    List<NodeSearchResult> xpathSearchResults = evaluator.getXpathSearchResults(inputXpaths.get(0));
    System.out.println(xpathSearchResults);
}