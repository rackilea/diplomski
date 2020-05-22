import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WindowServiceTest {

    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("sc query spooler");

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = reader.readLine();
            while (line != null) {
                if (line.trim().startsWith("STATE")) {
                    while (!"4".equals(line.trim().substring(line.trim().indexOf(":") + 1, line.trim().indexOf(":") + 4).trim())) {
                       System.out.println("Starting....");    
                     }
                      System.out.println("... Service is started and running");
                }
                line = reader.readLine();
                System.out.println("SERVICE DETAILS --> "+ line);
            }

        } catch (IOException e1) {
        } 

    }

}


OUTPUT
===========
SERVICE DETAILS --> SERVICE_NAME: spooler
SERVICE DETAILS -->         TYPE               : 110  WIN32_OWN_PROCESS (interactive)
SERVICE DETAILS -->         STATE              : 4  RUNNING 
... Service is started and running
SERVICE DETAILS -->                                 (STOPPABLE,NOT_PAUSABLE,ACCEPTS_SHUTDOWN)
SERVICE DETAILS -->         WIN32_EXIT_CODE    : 0  (0x0)
SERVICE DETAILS -->         SERVICE_EXIT_CODE  : 0  (0x0)
SERVICE DETAILS -->         CHECKPOINT         : 0x0
SERVICE DETAILS -->         WAIT_HINT          : 0x0
SERVICE DETAILS --> null