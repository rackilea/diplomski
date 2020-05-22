import java.io.File;


public class Demo
{

     private static final String files = null;
        //Directory path here

       /* public String ListFile(String files) {
            String path = "My/";//Use pathname like this
            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();
            {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        files = listOfFiles[i].getName();
                        if (files.endsWith(".xml")) {
                            System.out.println(files);
                        }
                    }
                }
            }
            return files;
        }
    */
    public File[] listf(String directoryName) {
        String files = "";
        File directory = new File(directoryName);
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (int i = 0; i < fList.length; i++) {

            if (fList[i].isFile()) {
                files = fList[i].getName();
                if (files.endsWith(".xml")) {
                    System.out.println(files);
                }
            }
        }

        //System.out.println(fList);//Not needed
        return fList;
    }




  public static void main (String[] args) {
  File f[]=new File[10];
  f=new Demo().listf("My");
    //new Demo().ListFile(files);//it just prints file names

//for(int i=0;i<f.length;i++)
   // System.out.println(f[i].getName());
  }

}