static ProgressBar bar;
    static int pb=0;
public static void copyFiles(final File srcFile,File destFile)  throws IOException{
        String mkDir= null;
        File mkDir1=null;
        String cpDir= null;
        File cpDir1=null;


        System.out.println("INSIDE METHOD :");

        {
            z=srcFile.listFiles();
            System.out.println("INSIDE FIRST LOOP");

            for (File f : srcFile.listFiles()) {
                if (f.isFile()) {
                    pb++;
                    System.out.println("File name ZZ: "+f.getName());
                    String sSrcDir=srcFile.getAbsolutePath().concat(File.separator).concat(f.getName());
                    System.out.println("sSrcDir: "+sSrcDir);
                    File sSrcFile=new File(sSrcDir);

                    File newFile = new File(destFile.getAbsolutePath().concat(File.separator).concat(f.getName()));
                    System.out.println("newFile: "+newFile);

                    FileUtils.copyFile(sSrcFile, newFile);
                    bar.setSelection (pb+1);
                    int x=pb+1;
                    System.out.println("bar.setSelection (j+1): "+x );
                    System.out.println("copy done for "+strSubDestDir +"to "+newFile);
                    //FileUtils.copyFile(srcFile, destFile);
                }
                else if(f.isDirectory())
                {
                    System.out.println("INSIDE DIRECTORY LOOP");
                    System.out.println("It is a directory"+f.getName());
                    cpDir=srcFile.getAbsolutePath().concat(File.separator).concat(f.getName());
                    cpDir1=new File(cpDir);
                    System.out.println("cpDir:  "+cpDir);
                    mkDir = destDir.getAbsolutePath().concat(File.separator).concat(f.getName());

                    mkDir1 = new File(mkDir);
                    System.out.println("mkDir : "+mkDir);
                    if( !mkDir1.exists() ) {
                        mkDir1.mkdir();
                    }
                    copyFiles(cpDir1, mkDir1);
                    //FileUtils.copyDirectory(cpDir1, mkDir1);
                }
            }
        }
    }