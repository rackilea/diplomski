public static class ParcelableParser<T> {
    private ArrayList<T> parse(List<T> parcelables) {
        ArrayList<T> parsedData = new ArrayList<T>();
        for(T parcelable : parcelables) {              
            parsedData.add(parcelable);
        }
        return parsedData;
    }
}