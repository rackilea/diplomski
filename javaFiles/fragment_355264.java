public static void main(String[] args) {    
    System.out.println("# of files "+search("C:\\Program Files (x86)\\Adobe"));    
}
public static int search(String folderpath){
    File directory = new File(folderpath);
    int numberOfFiles = 0;
    for (File element : directory.listFiles()){
        if (element.isDirectory()) { // count the files for this subdir
            numberOfFiles += search(element.getAbsolutePath());
        }
        else { // one more file
            numberOfFiles++;
            System.out.println(element);
        }
    }
    // return the number of files for this dir and its sub dirs
    return numberOfFiles;
}