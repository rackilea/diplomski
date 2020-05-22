public enum Yummy {
     CANDY("yelow candy"),
     CAKE("cookie");

     private String description;

     private Yummy(String description) {
         this.description= description;
     } 

     public String toString() {
         return this.description;
     }
}