public static void main(String...args){
    String str = "very good\uE056 flavor";
    System.out.println(str);
    System.out.println(removeUTF8(str));
}

public static String removeUTF8(String s){
    for(int i = 0; i < s.length(); i++){
        char targetChar = s.charAt(i);
        if(targetChar > 127){
            s = s.replaceAll(Character.toString(targetChar), "");
        }
    }
    return s;
}