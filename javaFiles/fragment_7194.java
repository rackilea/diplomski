void recSeq(int counter){
        if (counter <= 0 ) return; // first the exit condition
        int value = counter -1; 
        recSeq(value ); // go down to the bottom, in order to print values from lovest values to higher
        System.out.print(" "+(int)Math.pow(2, value )); // print the value
 }