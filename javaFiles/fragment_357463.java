public static void updateArray(){
    //extract string from temp
    for (int i = 0; i < tempArray.size(); i++){
        String temp = tempArray.get(i);
        char[] charz = temp.toCharArray();
        for (int j = 0; j < charz.length; j++){ 
                epidemicArray[i][j] = charz[j];
        }
    }
}