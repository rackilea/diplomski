public String extractWordFour(String text){
    int i=0;
    while (i<=text.length){
        return text.charAt(0) + extractWordFour(text.substring(i));
        i++;
    }
}