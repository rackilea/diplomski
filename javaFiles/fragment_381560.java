class Article {
   ...  

   @ManyToMany
   @JoinTable(...)
   private Set<Tag> tags = new HashSet<>();
}

class Tag {
   ...

   @ManyToMany(mappedBy = "tags")
   private Set<Article> articles = new HashSet<>();
}