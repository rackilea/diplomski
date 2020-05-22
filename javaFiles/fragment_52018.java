private Map<Integer, String[]> map = new HashMap<>();
public Controller(){
  map.put(1, die1);
  map.put(2, die2);
  map.put(3, die3);
}
public String getLetter(int number, int index){
    map.get(number)[index];
}