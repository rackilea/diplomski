String fileFinder(String fileName, String root){
    String pathToFile = "";
    File rootDir = new File(root);
    File[] files = rootDir.listFiles();
    for(File f:files){
        if(f.isDirectory()){
            //System.out.println(f.getAbsolutePath());
            pathToFile = fileFinder(fileName,f.getAbsolutePath());
        }
        else if(f.getName().equals(fileName)){
            pathToFile = f.getAbsolutePath();
        }
        if (!pathToFile.isEmpty())
          break;
    }
    return pathToFile;
}