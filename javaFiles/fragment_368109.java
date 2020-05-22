SuggestOracle oracle = new MultiWordSuggestOracle();
SuggestBox box = new SuggestBox(oracle);

try {
  MultiWordSuggestOracle multiWordOracle = (MultiWordSuggestOracle)box.getOracle();
  multiWordOracle.add("This awesome suggestion.");
} catch (ClassCastException e ) {
  // the oracle was not what you thought it was
}