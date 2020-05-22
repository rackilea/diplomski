StringBuilder outSB = new StringBuilder();
for(int i=0; i < str.length(); i++){
    if(str.charAt(i) == 'a' || str.charAt(i) == 'A') outSB.append("Alpha ");
    if(str.charAt(i) == 'b' || str.charAt(i) == 'B') outSB.append("Bravo ");
    // and so on
}
String output = outSB.toString();