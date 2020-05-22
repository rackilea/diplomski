//We don't want out of bounds issues
if(i<word.length()){
    v = isVowel(word.charAt(i+1));
} else {
    v = true; //Pretend last character is vowel to force the end 'op'
}

if (c == true && v == true)  {
    String front = word.substring(0,i+1);
    String back = word.substring(i+1,word.length());
    word =  front + "op" + back ;
    i=i+3;
    System.out.println("word " + word);
}