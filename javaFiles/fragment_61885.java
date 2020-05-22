public String getIdFromSearchData(String searchedProduct) {
  // iterate over your list
  for ( SearchData element : data ) {
    // compare searchedProduct to the paramater
    if ( searchedProduct.equals(element.getSearchedProduct()) {
      return element.getId();
    }
  }
  // in case nothing found
  return null;
}