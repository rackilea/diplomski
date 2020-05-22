public class Main
{

    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();
        try {
           String[] command = {"cmd.exe", "/k", "Start", "<path+yourfilename>"};
                Process p =  runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}