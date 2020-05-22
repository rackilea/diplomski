public class Main
{

    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("xdg-open <path+yourfilename>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}