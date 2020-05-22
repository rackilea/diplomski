public int[] getLowestFCostNodePos(List<List<Integer>> openList, int endx, int endy){
    // Declarations
    int fMin = 1000000;
    int[] cords = new int[2];
    int minX = -1;
    int minY = -1;

    // look for lowest F-cost node
    for (int i=0;i<openList.size();i++){
        // setting possible position
        int xTmp = openList.get(i).get(0);
        int yTmp = openList.get(i).get(1);

        int fCandidate = grid.get(xTmp).get(yTmp).getF(endx, endy);
        // compare F-values
        if (fMin > fCandidate) {
            // set temporary F-cost
            fMin = fCandidate;
            minX = xTmp;
            minY = yTmp;
        }//end if (compare F)
    }//end i loop

    // just in case
    if (openList.size() > 0){
        cords[0] = minX;
        cords[1] = minY;
        return cords;
    } else{
        System.out.print("openList is empty!");
        return null;
    }

} // end getLowestFCostNodePos