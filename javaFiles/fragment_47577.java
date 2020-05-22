Block<Document> doWhateverYouNeed = new Block<Document>() {
     @Override
     public void apply(final Document document) {
         //do whatever you need here
         System.out.println(document.toJson());
     }
};