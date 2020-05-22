import java.io.File;

public class CS1702_Lab7ex7_5 {
    public static void main(String args[]) {
        String dir_name = "c:\\tomcat\\apache-tomcat-7.0.72"; // Or another
                                                            // directory
     File dir = new File(dir_name);

    File[] dir_list = dir.listFiles();
    for (int i = 0; i < dir_list.length; ++i) {
        /*
         * dir_list[i].isDirectory(): True, print directory. False, print
         * "File"
         */
        System.out.println(dir_list[i].getName() + (dir_list[i].isDirectory() ? " Directory" : " File"));
    }

}