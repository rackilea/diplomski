public static boolean mod(int a, int b){
    if ( b < 0 ){
        b=b*-1;
    } 
    if ( a < 0 || b == 0){
        return false;
    }else if (a==b){ 
        return true;
    }else{ 
        return mod( a-b, b );
    }
}