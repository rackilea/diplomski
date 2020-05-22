public int getCountOfLetter(char letter) {
    count = 0;
    for(char character : tiles.toCharArray()) {
        if(character == letter)
           count ++;
    }
    return count;
}