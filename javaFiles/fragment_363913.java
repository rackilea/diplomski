class BookService {
      private List<BookServiceSource> sources;

      public Map<String, List<Book>> getBooksByCategory(Category category) {
          return sources.stream()
              .collect(Collectors.toMap(BookServiceSource::getName, 
                  source -> source.getBooksByCategory(category)));
      }
 }