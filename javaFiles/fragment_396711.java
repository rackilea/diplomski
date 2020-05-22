@Name("otherSeamComponent")
 public class OtherSeamComponent {

     /**
       * Seam will lookup a Seam Component by field name - myStateless
       *
       * Notice i am using the local interface
       */
     private @In MyStatelessLocal myStateless;

 }