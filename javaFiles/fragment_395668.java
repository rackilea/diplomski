import com.thoughtworks.qdox.JavaDocBuilder;
import javax.swing.JFrame;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaDocBuilder java = new JavaDocBuilder();
        java.addSourceTree(new java.io.File("."));
        for (String i : java.getClassByName("Main").getSource().getImports()) {
            System.out.println(i);
        }
    }
}