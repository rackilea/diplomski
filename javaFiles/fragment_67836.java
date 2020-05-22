for (int i=0; i < word.length(); i++){
    try{
       counts[word.charAt(i)-'A']++;
    }
     catch (ArrayIndexOutOfBoundsException Exception){
         System.out.println("Not a Letter: " + word.charAt(i));
    }
}