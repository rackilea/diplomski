class Player
 {
    String name;
    int rank;

     // your other code with constructor and getter, setter method    
  }

 ArrayList<Player>currentRankingsList = new ArrayList<>();

 Collections.sort(CurrentRankingsList, new Comparator<Player>() 
 {
    @Override
    public int compare(Player o1, Player o2) {
        // TODO Auto-generated method stub
                return o1.getName().compareTo(o2.getName());
     }
 }) ;