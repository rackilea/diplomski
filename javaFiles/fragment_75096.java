String[][] superBowl = new String[arraySize][1];
while (inputFile.hasNext()) {
    for (int index = 0; index < superBowl.length; index++) {
        superBowl[index][0] = inputFiles.next();
        superBowl[index][1] = inputFiles.nextLine();
    }
}