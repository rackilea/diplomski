import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main
{
    private static String PATH_TO_GRADLE_PROJECT = "./";
    private static String GRADLEW_EXECUTABLE = "gradlew.bat";
    private static String BALNK = " ";
    private static String GRADLE_TASK = "jar";

    public static void main(String[] args)
    {
        String command = PATH_TO_GRADLE_PROJECT + GRADLEW_EXECUTABLE + BALNK + GRADLE_TASK;
        try
        {
            Runtime.getRuntime().exec(command);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}