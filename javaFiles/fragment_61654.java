public class Transformation {

  public static void main (String[] args){
    transformation(".", ".");
  }

  public static void transform(String inXML, String inXSL, String outTXT, String renamedFile){
    System.out.println(inXML);
    System.out.println(inXSL);
    System.out.println(outTXT);
    System.out.println(renamedFile);
  }

  public static void transformation(String inFolder, String outFolder){
    File infolder = new File(inFolder);
    File outfolder = new File(outFolder);
    if (infolder.isDirectory() && outfolder.isDirectory()){
      System.out.println("In " + infolder.getAbsolutePath());
      System.out.println("Out " + outfolder.getAbsolutePath());
      File[] listOfFiles = infolder.listFiles();
      String outPath = outfolder.getAbsolutePath();
      String inPath = infolder.getAbsolutePath();
      for (File f: listOfFiles) {
        if (f.isFile() ) {
          System.out.println("File " + f.getName());
          int indDot = f.getName().lastIndexOf(".");
          String name = f.getName().substring(0, indDot);
          String ext = f.getName().substring(indDot+1);
          if (ext != null && ext.equals("html")){
            transform(f.getAbsolutePath(), inPath+File.separator+name+".xsl", outPath+File.separator+name+".txt", outPath+File.separator+name+".html");

          }
        }
      }       
    }
  }
}