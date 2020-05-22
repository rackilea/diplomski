public static void main(String[] args) throws Exception {
    int[] myArray = {1, 6, 43, 22, 4, 6, 4, 3, 8, 7, 3};
    int targetNumber = 9;

    for(int i = 0; i < myArray.length; i++){
        for(int j = i + 1; j < myArray.length; j++){
            if(myArray[i] + myArray[j] == targetNumber){
                System.out.println("The indexes are " + i + " and " + j);
                return;
            }
        }
    }   
    System.out.println("No match found");
}