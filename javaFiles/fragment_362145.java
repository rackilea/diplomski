static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
    // Complete this function
    int resultA = 0;
    int resultB = 0;
    int[] arrA = {a0,a1,a2};
    int[] arrB = {b0,b1,b2};
    for(int i = 0; i <3; i++){
        if (arrA[i] > arrB[i] && arrA[i] - arrB[i] != 0){
            resultA++;
        }else if(arrB[i] > arrA[i] && arrB[i] - arrA[i] != 0){resultB++ ;}
    }
    int[]  array = {resultA, resultB};
    return array;

}