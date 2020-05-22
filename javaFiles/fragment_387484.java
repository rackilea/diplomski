ArrayList<Character> myList = new ArrayList<>(Arrays.asList('C','A','R','D'));
char[][] myArray = new char[/*TODO size*/][/*TODO size*/];

outerloop:
for(int i =0; i < myArray.length; i++){
    for(int j =0; j < myArray[i].length; j++){
        if(myList.contains(myArray[i][j])){
            myList.remove(myArray[i][j]);
            myArray[i][j] = '.';
            if(myList.isEmpty()){
                break outerloop;
            }
        }
    }
}