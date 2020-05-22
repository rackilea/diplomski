import org.apache.commons.io.FileUtils;

public class B {

    public static void main(String[] args) throws Exception {
        File s = new File("C:/Tom/eso");         
        File d = new File("C:/Tom/pos");
        FileUtils.copyDirectory(s,d);
    }

}