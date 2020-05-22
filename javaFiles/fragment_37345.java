int maxIndex = 0;
    for (int i = 1; i < modetracker.length; i++) {
        int newnumber = modetracker[i];
        if ((newnumber > modetracker[maxIndex])) {
            maxIndex = i;
        }
    }
    System.out.println(maxIndex);