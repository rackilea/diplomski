public interface Controller {
   User getUser(int id);
}

public class RealController {
   public User getUser(int id) {
      return dao.getUser(id);
   }
}

public class DecoratedController {

   private Controller realController;

   public User getUser(int id) {
      // here you will apply dozer or do it manually creating an object with so deep as you wish
      return flatUserStructure(realController.getUser(id));
   }
}