static int minAbsVal(int[] myArray){

        Arrays.sort(myArray);
        int minimum=Math.abs( myArray[1] - myArray[0]);
        for (int i = 1; i < myArray.length-1; i++) {
            int diff = Math.abs( myArray[i+1] - myArray[i]);
            if (diff == 0)
                return 0;
            else if (minimum > diff)
                minimum = diff;
        }
        return minimum;
    }