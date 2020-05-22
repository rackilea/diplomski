import mainpackage.viewer;
public class Open implements closeInterface{

    public Open() { }
    public static String fileName;
    public static void main(String[] args) throws Exception {
        fileName = "C:/Files/Test.pdf";
        run();
    }

    @Override
    public void close() {
        System.out.print("The Viewer Has Been Closed");

    }

    public static void run() throws Exception
    {
        viewer view = new viewer();
        view.main(fileName);
        view.addListener(new Open());
    }
}