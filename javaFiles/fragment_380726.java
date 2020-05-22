@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Book {


   public int pages;

   // ...
   // ...
   // ...
   public static List<Book> findLargeBooks() {

        return entityManager().createQuery(
            "Select o from Book o where o.pages > 100", Book.class).getResultList();

   }


}