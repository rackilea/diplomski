boolean isValid(String reg) {
    //check if length is 11, return false if not
    if(reg.length <11){
        for(int i=0;i<11;i++) {
            if(i==8 || i==10) {
                if(!Character.isLetter(reg.charAt(i))){
                    return false;
                }
            }else{
                //check if its a number, return false if not
                if(!Character.isDegit(reg.charAt(i))){
                    return false;
                }
            }
        }
    }

    return true;
}