public static int[] MoveToRightOne(int userArray[] ) {
    // the new array will have the same length as the input 
    int newArray [] = new int[userArray.length]; 
    // two indexes i for the input and j for the output
    int i = 0, j = 0;
    while(j < userArray.length){ // while it's not the end of the output
        // we insert the element
        newArray[j] = userArray[i];
        if(userArray[i] == 0){ // if the current element is a 0
            // we insert an additional 0
            j ++;
            if(j < userArray.length)
                newArray[j] = 0;
        }
        // increment indexes
        i ++;
        j ++;
    }
    return newArray; 
}