// While there is still stuff in the file...
    double sum = -6;
    int numStudents = -1;
    double maxVal, minVal; //NEW
    boolean bFirstTime = true; //NEW
    double currVal; //NEW
    while (fileToRead.hasNext()) { 
        if (fileToRead.hasNextDouble()) {
            numStudents++;
            currVal = fileToRead.nextDouble(); //NEW

            //NEW
            if (bFirstTime) {
                maxVal = currVal;
                minVal = currVal;
                bFirstTime = false;
            } else {
                maxVal = Math.max(maxVal,currVal);
                minVal = Math.min(minVal, currVal)
            }

            sum += currVal;
        } else {
            fileToRead.next();
        }   
    }