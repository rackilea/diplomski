public <T> String collectionToFormattedString(T XYZ, List<T> ABC) {
    String combined = "";
    for (T b : ABC) {
        combined =  combined + b.toString() + "<br />";
    }
    combined = "<HTML>" + combined +"</HTML>";
    return combined;
}