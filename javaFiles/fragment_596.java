//variables to store generated card as string

    private String generatedCard;
   //create Array list for suits
  ArrayList<String> suits = new ArrayList<>();
  //fill the List
  suits.add("spades"); //index no [0]
  suits.add("hearts");
  suits.add("diamonds");
  suits.add("clubs"); //index no [3]
  //create Array list for numbers
   ArrayList<String> numbers = new ArrayList<>(); 
  //fill the list
   - - - -
  //create ArrayList for generated Cards
   ArrayList<String> cards = new ArrayList<>();
  //create Randomiser
    Random rnd = new Random();
  for (int i = 0; i <5; i++){
        generatedCard = ""+suits.get( rnd.nextInt(4)) + " " + numbers.get(rnd.nextInt(13)); 
      cards.add(i, generatedCard);
  }