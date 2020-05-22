class myClass {
     private Collection<T> theData;

     // Users need to access the data,
     // but we don't want them modifying the private data of this class
     public Collection<T> getTheData() {
         return Collections.unmodifiableCollection(theData);
     }
}