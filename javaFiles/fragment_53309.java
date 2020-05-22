public static void calculateBoxes(int[] ai_ToFill, int[] boxVolumes, int iNumberOfGPS) {
    // for each box size
    for (int iStepper = 0; iStepper < ai_ToFill.length; iStepper++) {
        // while the remaining items to pack is greater than the current box size
        while(iNumberOfGPS >= boxVolumes[iStepper]) {
            // increment the current box type
            ai_ToFill[iStepper]++;
            // subtract the items that just got packed
            iNumberOfGPS -= boxVolumes[iStepper];
        }
    }
}