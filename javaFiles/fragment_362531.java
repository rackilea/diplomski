char HamBurger(String s){

    for(int i=1;i<s.length();i++){
        if(s.charAt(i)==s.charAt(0)){
            return s.charAt(0);
        }
    }
    return '_';
}