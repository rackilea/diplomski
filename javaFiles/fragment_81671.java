public void addBookToLibrary(Book book){
        HashMap<String,String> bookFeatures = book.getFeatures();
        for(String featureType : bookFeatures.keySet()){
            HashMap<String,Book> libraryFeatureMap = library.get(featureType);
            libraryFeatureMap.put(bookFeatures.get(featureType), book);
        }
    }