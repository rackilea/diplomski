public static void main(String[] args){
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(5);list.add(2);// to be continued ...        
    int randomInt = list.get((int) (Math.random() * list.size()));
    System.out.println(randomInt);
}