public static void main(String args[]) {

    String[][] largeArray = new String[100][];
    int x = 30;
    for(int i = 0; i < x; i++){
        String [] smallerArray = new String[10];
        largeArray[i] = smallerArray;
    }

}