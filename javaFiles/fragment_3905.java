public class CreateJar {

public static void main(String[] args) throws IOException {
    String filePath = "/src";
    List<File> fileEntries = new ArrayList<>();
    getAllFileNames(new File(filePath), fileEntries);
    JarOutputStream jarStream = new JarOutputStream(new FileOutputStream(new File("a.jar")));
    for(File file : fileEntries){
        jarStream.putNextEntry(new ZipEntry(file.getAbsolutePath()));
        jarStream.write(getBytes(file));
        jarStream.closeEntry();
    }
    jarStream.close();
}

private static byte[] getBytes(File file){
    byte[] buffer = new byte[(int) file.length()];
    BufferedInputStream bis = null;
    try {
        bis = new BufferedInputStream(new FileInputStream(file));
        //Read it completely
        while((bis.read(buffer, 0, buffer.length))!=-1){
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }finally{
        try {
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return buffer;
}

private static void getAllFileNames(File file,List<File> list){
    if(file.isFile()){
        list.add(file);
    }else{
        for(File file1 : file.listFiles()){
            getAllFileNames(file1, list);
        }
    }
}
}