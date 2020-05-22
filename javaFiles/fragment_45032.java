int[][] gaps = new int[10][30];

for (int i = 0; i < (arr.size() - 1); i++) {

    int gapCount = 0;  // reset the gap count for the actual number

    for (int j = i + 1; j < arr.size(); j++) {

        if (arr.get(i) == arr.get(j)) {

            // we only track gaps greater than zero
            if(gapCount > 0) {  
                gaps[arr.get(i)][gapCount - 1]++; // increment the gap occurrence
            }

            break; // go to the next number in the list
        }

        gapCount++;

        // we don't want to track gaps greater than 30
        if(gapCount > 30) {
            break;
        }
    }
}