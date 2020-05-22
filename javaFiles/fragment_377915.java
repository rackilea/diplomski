String keysString = history.getKey();

//removes all "Key promo is" text
String replaceString=keysString.replace("Key promo is","");   
// removes all white spaces
String trimString = replaceString.replaceAll("\\s+",""); 

String[] keys = trimString.split(".");
for (int i = 0; i < keys.lenght; i++) {
    if (keys[i] == editText.getText()) {
        return true;
    }
}