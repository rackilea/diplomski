/** utility: pads two strings to columns per line */
protected String padLine(@Nullable String partOne, @Nullable String partTwo, int columnsPerLine){
    if(partOne == null) {partOne = "";}
    if(partTwo == null) {partTwo = "";}
    String concat;
    if((partOne.length() + partTwo.length()) > columnsPerLine) {
        concat = partOne + " " + partTwo;
    } else {
        int padding = columnsPerLine - (partOne.length() + partTwo.length());
        concat = partOne + repeat(" ", padding) + partTwo;
    }
    return concat;
}

/** utility: string repeat */
protected String repeat(String str, int i){
    return new String(new char[i]).replace("\0", str);
}