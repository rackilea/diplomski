String sentence="name    password    A";
    String username = "";
    String password ="";
    char SS ;

    //Result : name , password , type
    String[] result = new String[3] ;
    int i= 0 ;

    // To treat multiple spaces 
    boolean previousSpace = false ;

    String textHelper="";

    for(int j=0;j<sentence.length();j++){
        SS=sentence.charAt(j);
        char typehelper=' ';
        boolean typeend=false;

        if(SS!=' '){
            textHelper+=String.valueOf(SS);
            previousSpace = false ;
        }else if(SS==' ' && previousSpace == false ){
            result[i] = textHelper ;    
            textHelper = "" ;
            previousSpace = true ;
            i++ ;
        }

    }

    //Last Text ( type )
    result[i]= textHelper ;

    System.out.println("username " + result[0]);
    System.out.println("password " +result[1]);
    System.out.println("type " + result[2]);