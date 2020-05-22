File folderA = new File("/Users/you/folderA/");
File[] listOfFilesInA = folderA.listFiles();
File folderB = new File("/Users/you/folderB/");
File[] listOfFilesInB = folderB.listFiles();    
for (File fileA : listOfFilesInA) {
    if (fileA.isFile()) 
    {
        for (File fileB : listOfFilesInB) {
             if(fileB.isFile()) 
             {
                //your code 
             }
         } 
    }
}