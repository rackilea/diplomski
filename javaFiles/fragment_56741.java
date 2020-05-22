private static int[] merge(int[] left, int[] right) {
    int lengthResult = left.length + right.length;
    int[] result = new int[lengthResult];
    int indexL=0, indexR=0, indexResult = 0;

    //while there are elements left in left or right
    while(indexL < left.length || indexR < right.length){

        //BOTH left and right still have elements 
        if(indexL < left.length && indexR < right.length){
            //if the left item is greater than right item
            if(left[indexL] <= right[indexR]){
                result[indexResult] = left[indexL];
                indexL++;
                indexResult++;
            }else{
                result[indexResult] = right[indexR];
                indexR++;
                indexResult++;
            }
        //means only left OR right have elements left
            //see if left has stuff
        }else if(indexL < left.length){
            result[indexResult] = left[indexL];
            indexL++;
            indexResult++;
        }else if(indexR < right.length){
            result[indexResult] = right[indexR];
            indexR++;
            indexResult++;
        }
    }
    return result;
}