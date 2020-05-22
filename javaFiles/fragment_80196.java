public static void main(String[] args){
    boolean[] lockers = new boolean[100];
    for(int i = 0; i < lockers.length; i++){
        for (int j = i; j < lockers.length; j+=i){
            if (lockers[j] == false){
                lockers[j] = true;
            }
            else{
                lockers[j] = false;
            }
        }
    }
    for(int i = 0; i <lockers.length; i++){
        System.out.println(lockers[i] + " " + i);
    }
}