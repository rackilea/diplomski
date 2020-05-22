public class FileCopy {

public static void main(String[] args) {
    try {
        File srcFile = new File("/home/test001/sampleDir/sourcefile.wav");

        File dstFile = new File("/home/test001/sampleDir/dstFile.wav");
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(dstFile);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }

        in.close();
        out.close();

    } catch (Exception e) {
        System.out.println(e);
    }

}