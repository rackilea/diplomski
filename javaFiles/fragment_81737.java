/*
 *  A method to resize the array.
 *  @param  : newSize - new required size of array
 *  @return : true if widening, false if narrowing
 *
 */
public boolean resize(int newSize) { 

    boolean toReturn = true;

    // if narrowing or the size isn't being changed, return value changes to false; 
    if ( newSize <= strArray.length ){
         toReturn = false;
    }

    String[] newArray = new String[newSize];

    // yes, Java allows creating zero-sized arrays

    if(newSize != 0){

       // copying from old array to new one; it doesn't matter if this is narrowing 
       // or widening, everything that fits in will be copied
       System.arraycopy(strArray,0,newArray,0,newSize);

       // copying pointer to newArray to the variable where strArray used to be
       strArray = newArray;

    }
    return(toReturn);

}