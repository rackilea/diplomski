public class Assessor {

   boolean assess(Collection<Condition> conditions) {
      for (Condition c : conditions) {
        if (!c.evaluate()) {
           return false;
        }
      }
      // all conditions passed
      return true;
   }
}