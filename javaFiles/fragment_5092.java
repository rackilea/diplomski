public enum Suit {
   SPADE("Spade"),
   HEART("Heart"),
   DIAMOND("Diamond"),
   CLUB("Club");

   private String name;
   private Suit(String name) { this.name = name; } 

   public String toString() {return name;}
}