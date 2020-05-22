import java.util.Properties;
 import com.jcraft.jsch.ChannelExec;
 import com.jcraft.jsch.JSch;
 import com.jcraft.jsch.Session;


/**
* @author jangachary.s
*
*/
public class CpTest {

public static void main(String args[]) {
    String host = "192.168.01.69";
    String user = "username";
    String password = "password";
    // String command = "./test/stable-uniconnect-server-0.179/bin/launcher run";
    String src = "srcFolder";
    String dest = "destFolder";
    String cp = "cp " + src + "/fileName " + dest;
    try {
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        JSch jsch = new JSch();

        // Create a JSch session to connect to the server
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(password);
        session.setConfig(config);
        // Establish the connection
        session.connect();
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(cp);

        channel.connect();

        channel.setErrStream(System.err);
        System.out.println("Connected...");
        session.disconnect();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}