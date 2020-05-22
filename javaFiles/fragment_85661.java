public final class FileListing {

private Map packageMap;


public void createPackageStructure(String sourceDir) throws FileNotFoundException 
{
    FileListing fileListing = new FileListing();
File startingDirectory= new File(sourceDir);

    fileListing.packageMap = new HashMap();
    List<File> files = fileListing.getFileListing(startingDirectory,   fileListing.getPackageMap());

    fileListing.moveFiles(fileListing.packageMap);

}


public List<File> getFileListing(File aStartingDir, Map packageMap) throws   FileNotFoundException 
{
    validateDirectory(aStartingDir);
    List<File> result = getFileListingNoSort(aStartingDir,packageMap);
    Collections.sort(result);
    return result;
}


private List<File> getFileListingNoSort(File aStartingDir, Map packageMap) throws FileNotFoundException 
{  
    List<File> result = new ArrayList<File>();
    File[] filesAndDirs = aStartingDir.listFiles();
    List<File> filesDirs = Arrays.asList(filesAndDirs);

    for(File file : filesDirs) 
    {
       result.add(file); 
       if(file.isFile())
       {
           packageMap.put(file, readPackageName(file.getAbsolutePath()).replace(".", "/").replace(";", "/"));
       }
       else 
       {
           //must be a directory
           //recursive call!
           List<File> deeperList = getFileListingNoSort(file,packageMap);
           result.addAll(deeperList);
       }
    }
return result;
}

public String readPackageName(String filePath)
{
  String packageName=null;
  String line;
  String temp[] = new String[2];
  BufferedReader br=null;
  try{
      File javaFile =  new File(filePath);
      br = new BufferedReader(new FileReader(javaFile));
      while((line=br.readLine())!=null)
      {
          if(line.indexOf("package")!=-1)
          {
              temp = line.split(" ");
              break;
          }
      }
      br.close();

  }catch(FileNotFoundException fnfe)
  {
      fnfe.printStackTrace();
  }catch(IOException ioe)
  {
      ioe.printStackTrace();
  }
  return temp[1];
}

public void moveFiles(Map packageMap)
{
 Set keySet = packageMap.keySet();
 Iterator it = keySet.iterator();
     File sourceFile, destFile, destDirs;
 InputStream in = null;
 OutputStream out = null;
 byte[] buf = new byte[1024];
 int len;

     try{
     while(it.hasNext())
         {
        sourceFile = (File)it.next();
        destDirs = new File("src/"+(String)packageMap.get(sourceFile));
        destFile = new File("src/"+   (String)packageMap.get(sourceFile)+"/"+sourceFile.getName());
        destDirs.mkdirs();
        in = new FileInputStream(sourceFile);
        out = new FileOutputStream(destFile);

        while((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
        }
         }
   }catch(FileNotFoundException fnfe)
   {
       fnfe.printStackTrace();
   }catch(IOException ioe)
   {
       ioe.printStackTrace();
   }
}

static private void validateDirectory (File aDirectory) throws FileNotFoundException 
{
  if (aDirectory == null) {
    throw new IllegalArgumentException("Directory should not be null.");
  }
  if (!aDirectory.exists()) {
    throw new FileNotFoundException("Directory does not exist: " + aDirectory);
  }
  if (!aDirectory.isDirectory()) {
    throw new IllegalArgumentException("Is not a directory: " + aDirectory);
  }
  if (!aDirectory.canRead()) {
    throw new IllegalArgumentException("Directory cannot be read: " + aDirectory);
  }
}

public Map getPackageMap()
{
  return this.packageMap;
}
}