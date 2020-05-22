public String[] getHangmanImage(int number){
    return hangManImages[number]; //this will return only a String[] not String[][] 
}
//alternatively you can just do 
public void printHangman(int number){
    for(int i = 0; i < hangmanImages[number].length; i++){
        System.err.println(hangmanImages[number][i]);
    }
}