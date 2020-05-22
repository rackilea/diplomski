for(File textFile:new File("Files").listFiles()){
    Scanner ScanningFile = new Scanner(textFile);
    try{ 
        //...
    }finally{
        ScanningFile.close();
    }
}