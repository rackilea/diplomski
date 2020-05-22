public int numberOfWords(){
    int words = 0;
    for(String s:arraylist) {         
      words += s.split(" ").length;
    }
    return words;
}