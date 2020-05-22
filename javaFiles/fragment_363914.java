interface BookServiceSource {
    String getName();
    List<Book> getBooksByCategory(Category category);
}

class MerlinSource implements BookServiceSource {
    private JSoupService service;
    private MerlinUrlProperties properties;

    @Override
    public String getName() {
      return "merlin";
    }

    @Override
    public List<Book> getBooksByCategory(Category category) {
      // at this point, we have both 
      // JSoupService (to make a real request) and 
      // MerlinUrlProperties (to prepare everything for that request)
    }
}