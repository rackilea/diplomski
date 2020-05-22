public class Something {
     private final List list = new ArrayList();

     public void add( String value ) {
         this.list.add( value );
     }
     public int count() {
          return this.list.size();
     }
 }