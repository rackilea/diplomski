public void compareFiles(String file1, String file2){
    // Read the lines of each file into String[] arrays
    String[] file1Lines = readAndSplitIntoLines(file1);
    String[] file2Lines = readAndSplitIntoLines(file2);

    // compare the lines
    for (int x=0;x<file1Lines.length;x++){
        for (int y=0;y<file2Lines.length;y++){
            if (file1Lines[x].equals(file2Lines[y])){
                // match. set it to null
                file1Lines[x] = null;
                file2Lines[y] = null;
                // break out of the inner loop and start comparing the next line
                break;
            }
        }

    // remove the duplicates (which are now null values), creating a smaller array of uniques.
    String[] newFile1 = shrinkArrayByRemovingNulls(file1Lines);
    String[] newFile2 = shrinkArrayByRemovingNulls(file2Lines);
    }