public static void main(String[] args){
    /*************************
    * comments on your code
    int[] fibarray; //use right java naming convention
    int numCount = 0; //this variable is never used
    int i = 0;
    long sum = 0;
    fibarray = new int[i];//you initialize an array of size 0.
    fibarray[0] = 0; //you can't set value to array of size 0
    fibarray[1] = 1; //you can't set value to array of size 0

    //wrong syntax
    for(i = 0 , fibarray[i] < 4000000, i++;;){
    //use for(i = 0 ; fibarray[i] < 4000000; i++){

        fibarray[i] = fibarray[i - 1] + fibarray[i - 2];
    }

    *******************************/
    //Alternative code
    //you don't need to keep all Fibonachi numbers found.
    //you only use 3 numbers for every calculation
    int size = 3;
    int totalLimit = 4000000;
    int[] fibArray = new int[size];
    fibArray[0] = 0;  fibArray[1] = 1;
    int total = 0;

    while( true ) {

        fibArray[2] = fibArray[0] + fibArray[1] ;

        if((fibArray[2]%2) ==0) { //even number

            if((total + fibArray[2]) >= totalLimit) {
                break;
            }

            total += fibArray[2];
        }

        fibArray[0] = fibArray[1] ;
        fibArray[1] = fibArray[2] ;
    }

    System.out.println("Total "+  total );  
}