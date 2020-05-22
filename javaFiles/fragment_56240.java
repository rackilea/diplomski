@Dependant
public class Bean2 extends AbstractClass implements Serializable {

    private String pathDir; 

    public Bean2(String param1, boolean param2) {
         super(param1, param2);
    }

    public void setPathDir(String pathDir) {
        this.pathDir = pathDir;
    }

    public void foo() {
        File file = new File(pathDir);
    }
}