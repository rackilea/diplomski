public static boolean[] checkString(String string){

    String[] stringarray = string.split(" ");
    boolean[] boolarray = new boolean[stringarray.length];
    for (int i = 0; i < stringarray.length; i++){
        if (stringarray[i].checkDictionaryForMatches() == true){
            boolarray[i] = true;
        }
        else{
            StringBuilder sb = new StringBuilder(stringarray[i]);
            for (int j = 0; j < sb.length(); j++){
                if (sb.charAt(j) == '!'){
                    sb.deleteCharAt(j);
                }
            }

            if (sb.toString().checkDictionaryForMatches() == true){
                boolarray[i] = true;
            }
            else{
                boolarray[i] = false;
            }
        }
    }
    return boolarray;
}