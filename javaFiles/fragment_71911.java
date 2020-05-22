public static void main(String[] args) {
    for ( int i = 1; i <=100; i++ ){
        if ( mod(i, 3) ){
            System.out.println(i);
        }
    }
}

public static boolean mod(int a, int b){
    if ( a < 0 ){
        return false;
    }else if (a==b){ 
        return true;
    }else{ 
        return mod( a-b, b );
    }
}