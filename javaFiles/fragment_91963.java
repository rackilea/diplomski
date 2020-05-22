private boolean  CharToString(){
String lineOfText = "XXXXXX";
String desiredResult = "X";
String actualResult = "initialised value";
for(int i = 0; i < lineOfText.length(); i ++){
    actualResult = Character.toString(lineOfText.charAt(i));
    }
if(desiredResult.equals(actualResult)){
    return true;
} else{
    return false;
}
}