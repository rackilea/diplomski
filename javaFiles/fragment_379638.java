import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaNetPU");
  static EntityManager em = emf.createEntityManager();

  public static void main(String[] a) throws Exception {
    em.getTransaction().begin();


    Category category = new Category();

    em.persist(category);

    category.setName("EN", "Business");
    category.setDescription("EN", "This is the business category");


    category.setName("FR", "La Business");
    category.setDescription("FR", "Ici es la Business");

    em.flush();

    System.out.println(category.getDescription("EN"));
    System.out.println(category.getName("FR"));


    Category c2 = new Category();
    em.persist(c2);

    c2.setDescription("EN", "Second Description");
    c2.setName("EN", "Second Name");

    c2.setDescription("DE", "Zwei  Description");
    c2.setName("DE", "Zwei  Name");

    em.flush();


    //em.remove(category);


    em.getTransaction().commit();
    em.close();
    emf.close();

  }
}