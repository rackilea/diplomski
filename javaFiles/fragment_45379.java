@Cacheable(value = "books", key = {"#p1","#p2","#p3"})
public List<Book> findBooks(Long loggedUserId, String q, Integer firstResult, Integer maxResults) {

...

return result;

}