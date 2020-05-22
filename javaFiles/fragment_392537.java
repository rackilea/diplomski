String [] splittedString  = inputString.split(" ");

for(int i = 0;i< splittedString.length; i++){
    String currentWord = splittedString[i];

    if(currentWord.length() >= min){
        finalcount++;
    }
}