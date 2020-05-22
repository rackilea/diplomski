public static String reverse (String text){
        String ret = "";
        for( int i = text.length()-1 ; i >= 0; i--){

           ret=ret+text.charAt(i);
        }

        return ret;
    }