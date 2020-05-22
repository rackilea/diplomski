import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A generator simulative of Radius log. Generate lines of log and save to a file. 
 * The parameters expected, in order, are: 
 *  - Number of users, integer(will be number of threads running simultaneously)
 *  - Number of NAS, integer
 *  - Number of seconds to sleep between the previous Stop and the next Start of each thread, integer
 *  - The full path of log file, string (the app in Windows has right to create file, but not the parent folder,
 *      so be sure to create the parent folder first)
 *  
 *
 */
public class RadiusSimulator implements Runnable {
    private static File log;
    private static volatile Map<String, String> user_nas; //ensure the newest value read from main heap; use volatile because we read but not write.
    private static final SimpleDateFormat fmt_in = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss.SSS");

    /* fields in tuple */
    private static final String FIELD_DATE = "date";
    private static final String FIELD_USERNAME = "User-Name";
    private static final String FIELD_NAS_IDENTIFIER = "NAS-Identifier";
    private static final String FIELD_METHOD = "Acct-Status-Type";
    private static final String FIELD_BALANCE_INPUT = "Acct-Input-Octets";
    private static final String FIELD_BALANCE_OUTPUT = "Acct-Output-Octets";

    /* methods */
    private static final String METHOD_START = "Start";
    private static final String METHOD_UPDATE = "Interim-Update";
    private static final String METHOD_STOP = "Stop";

    /* parameters */
    private static int numUsers;
    private static int numNAS;
    private static int sleepTime;

    private String username;
    private String nas;
    private String method;
    private String result;
    private int input;
    private int output;

    private FileWriter writer;
    private int status;
    private boolean stop;
    private String name;


    public RadiusSimulator(String name) {
        this.name = name;
        this.method = METHOD_START;
        status = 0;
        stop = false;
        // just open the file without appending, to clear content
        try {
            writer = new FileWriter(log, false);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        try {
            System.out.println("/**\r\n" + 
                    " * A simulated generator of Radius log. Generate lines of log and save to a file. \r\n" + 
                    " * The parameters expected, in order, are: \r\n" + 
                    " *  - Number of users, integer(will be number of threads running simultaneously)\r\n" + 
                    " *  - Number of NAS, integer\r\n" + 
                    " *  - Number of maximum of seconds to sleep between the previous Stop and the next Start of each thread, integer(>60)\r\n" + 
                    " *  - The full path of log file, string (be sure to create the parent folder first)\r\n" + 
                    " *  \r\n" + 
                    " * (require Java 1.7 or above) \r\n\"" +
                    " *  \r\n" + 
                    " *\r\n" + 
                    " */");

            System.out.println("Initializing with parameters: number of users: " + args[0] + ", number of NAS: " + args[1]);
            numUsers = Integer.parseInt(args[0]);
            numNAS = Integer.parseInt(args[1]);
            sleepTime = Integer.parseInt(args[2]);
            log = new File(args[3]);
            for (int i=0; i<numUsers; i++) {
                new Thread(new RadiusSimulator("User_" + i)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private int generateRandom(int min, int max) {
        if (max < min) max = min;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    private static String concat(String a, String b) {
        return a + "=" + b + ";;";
    }

    private void formLine() throws IOException {
        result += concat(FIELD_DATE, fmt_in.format(new Date())); //print always the date of now
        result += concat(FIELD_USERNAME, name);
        result += concat(FIELD_NAS_IDENTIFIER, nas);
        result += concat(FIELD_METHOD, method);
        result += concat(FIELD_BALANCE_INPUT, String.valueOf(input));
        result += concat(FIELD_BALANCE_OUTPUT, String.valueOf(output));
        result += System.lineSeparator();
    }
    @Override
    public void run() {
        try {
            writer = new FileWriter(log, true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
//        while (!stop) {
        while (true) {
            try {
                Thread.sleep(generateRandom(0, 3000));
                if (status == 0) {
                    // stage 1
                    int indexUser = generateRandom(0, numUsers-1);
                    username = "User_" + String.valueOf(indexUser);
                    int indexNas = generateRandom(0, numNAS-1);
                    nas = "NAS_" + String.valueOf(indexNas);
                    user_nas = new HashMap<String, String>();
                    result = "";
                    input = 0;
                    output = 0;
                    //first line
                    user_nas.put(username, nas);
                    formLine();
                    System.out.println(result);
                    writer.write(result);
                    writer.flush();
                    status ++; //next stage
                    result = "";
                } else if (status == 1) {
                    method = METHOD_UPDATE;
                    input += generateRandom(0, 400);
                    output += generateRandom(0, 500);
                    formLine();
                    System.out.println(result);
                    writer.write(result);
                    writer.flush();
                    // 1 out of 10 of probability to enter stage 3
                    if (generateRandom(0, 10) == 9) {
                        status = 2;
                    }
                    result = "";
                } else if (status == 2) {
                    method = METHOD_STOP;
                    input += generateRandom(0, 400);
                    output += generateRandom(0, 500);
                    formLine();
                    System.out.println(result);
                    /* write inmediately after constructing the line */
                    writer.write(result);
                    writer.flush();
                    user_nas.remove(username);
                    input = 0;
                    output = 0;
//                    stop = true;
                    result = "";
                    status = 0; //go back to stage 1
                    Thread.sleep(generateRandom(60*1000, sleepTime*1000));
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}