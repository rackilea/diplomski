@Entity
      public class Word {
      @ManyToMany
      Set<Category> categories;

      @Entity
      public class Category {
      @ManyToMany(mappedBy="categories")
      Set<Word> words;

       // call you entity manager to remove a category
       em.remove(category);
       for (Word word : category.words) {
            word.categories.remove(category);
       }