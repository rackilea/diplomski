public static void main(String[] args) {
    String s = reverseSentence("This sentence will be reversed - I swear".split(" "));
    System.out.println(s);
}

public static String reverseSentence(String[] sentence){
    if (sentence.length <= 1){
        return sentence[0];
    }
    String[] newArray = new String[sentence.length-1];
    for (int i = 0 ; i < newArray.length ; i++){
        newArray[i] = sentence[i];
    }
    return sentence[sentence.length-1] + " " + reverseSentence(newArray);
}