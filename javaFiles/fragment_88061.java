// void --> List<Integer>
 // static 
 public List<Integer>  myArrayOne() {
     ArrayList<Integer> packOfCards = new ArrayList<Integer>();
     Random rand = new Random();

     for (int j = 0; j<5; j++)
     {
         pick = rand.nextInt(10);
         packOfCards.add(pick);
     }

     // myArrayOne(); --> packOfCards
     return packOfCards;
}

public static void main(String[] args) {
      myattributes attributes = new myattributes();
      List<Integer> values = attributes.myArrayOne(); 
}