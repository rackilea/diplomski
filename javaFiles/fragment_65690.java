// global scope
List<Integer> container = new ArrayList<>();

//populate it
for(int i =1; i<=8; i++){
   container.add(i);
}
..........
..........
..........
public static int getRandom(){
    //to refill it if ya need to call it more than 8 times
    //if(container.size()==0){for(int i=1; i<=8; i++){container.add(i);} 
    Random generator = new Random();

    Integer randomNumber = container.get(generator.nextInt(container.size()));

    container.remove(randomNumber);

    return randomNumber;
}