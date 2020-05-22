class Pair {

     private final String face;  
     private final String suit;  

     Pair(String suit, String face) {
         this.face = face; 
         this.suit = suit;             
     }
     @Override
     public String toString() {
        return "(" + suit + ", " + face + ")";
     }
}