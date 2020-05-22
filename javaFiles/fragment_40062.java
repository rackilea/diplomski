import java.io.*;
import java.util.*;

public class CmdLineUI implements ChatUI, Chat {

    public static final String WRITE = "write";
    public static final String READ = "read";
    public static final String EXIT = "exit";
    public static final String ERRORMESSAGE = "unknown command";

    private BufferedReader userInput;

    public static void main(String[] args) throws Exception {
        PrintStream os = System.out;
        os.println("***Welcome to The ChatSystem:  input: write for chatting ,"
                + "\n    for Reading the messages input: read ,for closing Chat input: exit ***");

        CmdLineUI userCmd = new CmdLineUI();

        userCmd.runUi(System.in, System.out);

    }

    @Override
    public void writeMessage(String message) throws Exception {
        System.out.println("Start with Writing mode:");
        try {
            File file = new File("/home/sami/Desktop/file.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in); // A stream for reading from the
                                                                                    // console
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // Connect InputStreamReader to a
                                                                                    // BufferedReader

            FileWriter fileReader = new FileWriter(file); // A stream that connects to the text file
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // Connect the FileWriter to the
                                                                            // BufferedWriter

            String line;
            boolean continuee = true;
            while (!(line = bufferedReader.readLine()).equals("stop")) {
                continuee = false;
                bufferedWriter.write(line);
            }

            // Close the stream
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void readMessage() throws Exception {
        System.out.println("start with reading mode:");
        File file = new File("/home/sami/Desktop/file.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            String oneByte;
            while ((oneByte = br.readLine()) != null) {
                System.out.println(oneByte);
            }

        }

        catch (Exception ex) {
            ex.getMessage();
        }

    }

    @Override
    public void runUi(InputStream inp, OutputStream outp) throws IOException {
        this.userInput = new BufferedReader(new InputStreamReader(inp));

        BufferedReader br = new BufferedReader(userInput);
        PrintStream ps = new PrintStream(outp);

        CmdLineUI userCmd = new CmdLineUI();

        String commandLinString = null;
        boolean again = true;
        try {
            while (again) {

                System.out.println("> ");
                commandLinString = br.readLine().trim();
                StringTokenizer st = new StringTokenizer(commandLinString);
                String command = st.nextToken();
                // String msg= userCmd.readCommands(command);
                System.out.println("command :" + command);
                switch (command) {

                case WRITE:

                    writeMessage(command);
                    again = true;
                    break;

                case READ:

                    readMessage();

                    again = true;
                    break;
                case EXIT:

                    again = false;
                    break;
                default:
                    ps.println(ERRORMESSAGE);
                }

            }

        } catch (Exception e) {
            System.out.println("Exception when reading from comman line" + e.getLocalizedMessage());

        }

    }

}