public String getIdFromSearchData(String searchedProduct) {
    SearchData d = new SeardData(null, searchedProduct);
    if ( data.contains(d) ) {
        d = data.get(data.indexOf(d));
        return d.getId();
    }
    return null;
}