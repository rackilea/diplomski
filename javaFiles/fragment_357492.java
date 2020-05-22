import java.io.*;
import java.util.*;
import java.util.zip.*;
class MyUnZip
{
    FileInputStream fis;
    BufferedInputStream bis;
    ZipInputStream zis;
    FileOutputStream fos;
    BufferedOutputStream bos;
    public MyUnZip(String inputFile)throws IOException{
        String path1=inputFile.substring(0,inputFile.lastIndexOf('.'));
        //System.out.println(path1);

        fis=new FileInputStream(inputFile);
        bis=new BufferedInputStream(fis);
        zis=new ZipInputStream(bis);

        File outputFile;
        ZipEntry ze=null;

        while((ze=zis.getNextEntry())!=null){
            String str=ze.getName();
            //System.out.println(str);
            File fileName=new File(str);

            String path2=str.substring(str.indexOf('\\'),str.lastIndexOf('\\'));
            //System.out.println(path2);

            String path3=path1+path2;
            System.out.println(path3);

            File filePath=new File(path3);
            filePath.mkdirs();
            outputFile=new File(path3,fileName.getName());
            fos=new FileOutputStream(outputFile);
            bos=new BufferedOutputStream(fos);
            int ch;
            while((ch=zis.read())!=-1)
                bos.write(ch);
            bos.close();
            fos.close();
            zis.closeEntry();
        }
        zis.close();
    }
    public static void main(String args[]) throws IOException{
        Console con=System.console();
        System.out.println("Enter the path of zip file to be uncompressed:");
        String inputFile=con.readLine();
        new MyUnZip(inputFile);
    }
}