for(int j = h20 ; j < h21 ; j++){
    int tmp1 = j*h31;
    int tmp2 = (j+decY)*w11 + decX;
    int tmp3 = j*w21;

    // j won't change inside here, so you can simply use the precalculated values
    for(int i = w20 ; i < w21 ; i++){
        if( int_color == arr3[tmp1 + i] )  continue; //condition 
        arr1[tmp2 + i] = arr2[tmp3 + i];      
    }   
}