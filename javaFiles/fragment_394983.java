public final class Filehandling {

    private Filehandling() {
    }

    public static void writeFile(Context context, String Filename, String Text) throws IOException {
        FileOutputStream fos = context.openFileOutput(Filename, Context.MODE_PRIVATE);
        fos.write(Text.getBytes());
        fos.close();
    }

    public sttaic void readFile(Context context, String File) throws IOException {
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(context.openFileInput(File)));
            String inputString;
            StringBuffer stringBuffer = new StringBuffer();
            inputString = inputReader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

public class IPandPort {


    public static void setIp(Context context) {
        try {
            FileHandling.writeFile(context, "file.txt", "yourtext");
        } catch (IOException e) {
            // TODO
        }
    }
}