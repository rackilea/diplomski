String[][] superBowl = new String[arraySize][2];
file = new File(fileName);
inputFile = new Scanner(file);
while (inputFile.hasNext()) {
    for (int index = 0; index < superBowl.length; index++) {
        superBowl[index][0] = inputFiles.next();
        superBowl[index][1] = inputFiles.nextLine();
    }
}