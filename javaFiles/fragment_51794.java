StringBuilder sb = new StringBuilder()
String currentString;
for(int i = 0, j = 1; j <= encodedString.length(); j++){
    currentString = encodedString.substring(i, j)
    if(huffEncodeTable.containsKey( currentString )){

        sb.append(huffEncodeTable.get( currentString ));
        i = j;      

    }
}
return sb.toString(); //Or whatever you do with it.