public static void calculateBoxes(int[] ai_ToFill, int[] boxVolumes, int iNumberOfGPS) {
    // for each box size
    for (int iStepper = 0; iStepper < ai_ToFill.length; iStepper++) {
        if(iNumberOfGPS >= boxVolumes[iStepper]) {
            // calculate the number of boxes that could be filled by the items
            ai_ToFill[iStepper] = iNumberOfGPS/boxVolumes[iStepper];
            // reset the count of items to the remainder
            iNumberOfGPS = iNumberOfGPS%boxVolumes[iStepper];
        }
    }
}