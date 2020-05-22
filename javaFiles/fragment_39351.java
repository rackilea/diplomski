String phrase = "The last word of this sentence is stackoverflow";
String subPhrase = phrase;
while(true) {
    String temp = subPhrase.substring(1 + subPhrase.indexOf(" "));
    if(temp.equals(subPhrase)) {
        break;
    } else {
        subPhrase = temp;
    }
}
System.out.println(subPhrase);