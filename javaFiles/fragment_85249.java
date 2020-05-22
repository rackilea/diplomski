public List<Object> getCategories() throws Exception{
    // Note: this is now a *local* variable. There was no need for it to be an
    // instance variable as far as I can see.
    // If you're using Java 7 or higher, you can use new ArrayList<>(); too.
    List<Category> catList = new ArrayList<Category>();
    ...
}