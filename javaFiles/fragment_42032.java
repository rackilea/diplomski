public class Inception {
   public void dream() {
      boolean enoughDreaming = false;
      //Some code logic below to check if it's high time to stop dreaming recursively
      ...
      ...

      if(!enoughDreaming) {
           dream(); //Dream inside a Dream
      }
   }
}