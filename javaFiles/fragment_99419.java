import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class Main {

    public static void main(String[] args) throws Exception {
        IFEProcess fe=load(new File("jason.json"));
        save(new File("txt.json"),fe);
    }

    public static IFEProcess load(File file) throws FileNotFoundException,
            IOException, ClassNotFoundException {
        Gson gson = new Gson();
        String json = FileHelper.getStringFromFile(file);

        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);

        return gson.fromJson(reader, FEProcess.class);
    }

    public static void save(File file, IFEProcess process) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(process);

        FileHelper.writeStringToFile(json, file);
    }

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

    public static String getStringFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));
            String line;
            while ((line = buff.readLine()) != null)
                sb.append(line + "\n");
                buff.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        public static void writeStringToFile(String json, File file) {
            FileWriter fw;
            try {
                fw = new FileWriter(file);
                fw.write(json);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    import java.util.ArrayList;


    public class FEProcess implements IFEProcess {

        String  description;
        String    altMailAdress;
        boolean   mailOnError;
        boolean   stopOnError;
        ArrayList<Operation> operationList;


    }

public class Operation {

    LConfig lConfig;
    OperationConfig operationConfig;
    String fileOperationType;

    class fopConfiguration {
            String fopPath;
            String fopTime;
        }

    }

public class LConfig {

    String password;
    String username;
    int port;
    String additionalLoginInformations;
    String hostname;
    boolean isToRemoteTransfer;
    String domain;
    String sambaShare;

}

public class OperationConfig {

    String remoteDirectory;
    String localDirectory;
    String sourceSemaphoreSuffix;
    String sourceSemaphoreType;
    String targetSemaphoreSuffix;
    String targetSemaphoreType;
    String sourceFilePattern;
    boolean lock;
    boolean delete;
    boolean backup;
    boolean noOverwrite;
    String fileRenameRegex;
    String fileRenameContent;


}