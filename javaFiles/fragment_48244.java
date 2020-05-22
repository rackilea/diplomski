// You'll need this import: import java.io.File;

File folder = new File("C:/Folder_Location");
// gets you the list of files at this folder
File[] listOfFiles = folder.listFiles();
// loop through each of the files looking for filenames that match
for(int i = 0; i < listOfFile.length; i++){
    String filename = listOfFiles[i].getName();
    if(filename.startsWith("Stuff") && listOfFiles[i].getName().endsWith("OtherStuff")){
        // do something with the filename
    }
}