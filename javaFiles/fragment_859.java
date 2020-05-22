static int minAbsVal(int[] myArray){

            Arrays.sort(myArray);
            ArrayList<Integer> diffs= new ArrayList<Integer>(); // all absolute value differences

            for (int i = 0; i < myArray.length-1; i++) {
                diffs.add(Math.abs( myArray[i+1] - myArray[i]));
            }

            Collections.sort(diffs);
            return diffs.get(0);
        }