import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {

private String startingFolderPath;
private String outputZipFilePath;

private List<String> fileList;

/**
 * Zip files
 */
public void zipFiles(){

    byte[] buffer = new byte[1024];

    try{

        if (fileList == null) {
            fileList = new ArrayList<String>();
            generateFileList(new File(startingFolderPath));
        }

        System.out.println("File Count:" + fileList.size());
        FileOutputStream fos = new FileOutputStream(outputZipFilePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        System.out.println("Output to Zip : " + outputZipFilePath);

        for(String file : fileList){

            System.out.println("File Included : " + file);
            ZipEntry ze= new ZipEntry(file);
            zos.putNextEntry(ze);

            FileInputStream in =
                    new FileInputStream(startingFolderPath + File.separator + file);

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
        }

        zos.closeEntry();
        //remember close it
        zos.close();

        System.out.println("Done");
    }catch(IOException ex){
        ex.printStackTrace();
    }
}

/**
 * Traverse a directory and get all files,
 * and add the file into fileList
 * @param node file or directory
 */
public void generateFileList(File node) throws IOException {

    //add file only
    if(node.isFile()){
        fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
    }

    if(node.isDirectory()){
        String[] subNote = node.list();
        for(String filename : subNote){
            generateFileList(new File(node, filename));
        }
    }

}

/**
 * Format the file path for zip
 * @param file file path
 * @return Formatted file path
 */
private String generateZipEntry(String file){
    return file.substring(startingFolderPath.length()+1, file.length());
}

public void setStartingFolderPath(String startingFolderPath) {
    this.startingFolderPath = startingFolderPath;
}

public void setOutputZipFilePath(String outputZipFilePath) {
    this.outputZipFilePath = outputZipFilePath;
}