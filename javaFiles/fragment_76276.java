public static int[][] arraySplitByDelimiter(int[] inputArray, int delimiter) {

           //Make an array to hold our results, ideally it would be nice to use an ArrayList
        //so that it can expand dynamically but instead we can also make one that we know will be big enough
        //if every other int is a delimiter then we can end up with a result array of inputArray.length / 2
        int[][] temporaryResultArray = new int[inputArray.length / 2][];
        int numberOfResultArrays = 0;

        int lastDelimterPosition = 0;

        for (int i = 0; i < inputArray.length; i++) {
            //If we find a delimeter copy the chunk of the input array to a new array in the temporaryResultArray
            if (inputArray[i] == delimiter) {
                temporaryResultArray[numberOfResultArrays++] = Arrays.copyOfRange(inputArray, lastDelimterPosition, i);
                lastDelimterPosition = i + 1;
            } else if (i == (inputArray.length - 1)) {
                //If we're at the end of the array then we should copy the last chunk to new array
                temporaryResultArray[numberOfResultArrays++] = Arrays.copyOfRange(inputArray, lastDelimterPosition, inputArray.length);
            }
        }

        int[][] finalResultArray = new int[numberOfResultArrays][];
        for (int i = 0; i < numberOfResultArrays; i++) {
            finalResultArray[i] = temporaryResultArray[i];
        }

        return finalResultArray;

    }