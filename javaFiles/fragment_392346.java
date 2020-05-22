for (int i = 0; i < strb.length(); i++) {
    if(strb.charAt(i)<'a'||strb.charAt(i)>'z'){
        strb.deleteCharAt(i);
        i--;
    } 

}