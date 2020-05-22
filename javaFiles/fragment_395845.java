public static boolean validname(String name){
    boolean boo = true;
    String nameUp=name.toUpperCase();
    for(int i=0;i<nameUp.length();i++){

        char charUp=nameUp.charAt(i);

            if(charUp!='A' && charUp!='B' && charUp!='C' && charUp!='D' && charUp!='E' && charUp!='F' && charUp!='G' && charUp!='H' && charUp!='I' && charUp!='J' && charUp!='K' && charUp!='L' && charUp!='M' && charUp!='N' && charUp!='O' && charUp!='P' && charUp!='Q' && charUp!='R' && charUp!='S' && charUp!='T' && charUp!='U' && charUp!='V' && charUp!='W' && charUp!='X' && charUp!='Y' && charUp!='Z' && charUp!='.' && charUp!=' '){
            boo = false;
        }
    }
    return boo;

}//valid name