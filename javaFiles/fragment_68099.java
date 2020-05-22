import java.io.IOException;
import java.io.PrintStream;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class MyShell {

    static String user = "daniel";
    static String host = "localhost";
    static int port = 22;
    static String password = "mypass";
    static Session session;
    static Channel shellChannel;
    static PrintStream shellStream;

    public static void main(String[] args) throws JSchException, IOException,
            InterruptedException {

        JSch jsch = new JSch();
        jsch.removeAllIdentity();
        session = jsch.getSession(user, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setConfig("PubkeyAuthentication", "no");
        System.out.println("Establishing Connection...");
        session.setConfig("PreferredAuthentications",
                "publickey,keyboard-interactive,password");
        session.connect();
        System.out.println("Connection established.");
        System.out.println("Crating SFTP Channel.");

        shellChannel = session.openChannel("shell");
        shellChannel.connect();
        ((ChannelShell) shellChannel).setPty(true);
        shellChannel.setInputStream(System.in);
        shellChannel.setOutputStream(System.out);
        shellStream = new PrintStream(shellChannel.getOutputStream());

        Thread.sleep(1000);
        sendCommand("sudo su");
        Thread.sleep(1000);
        sendCommand("mypass");
        Thread.sleep(1000);
        sendCommand("ls");

    }

    public static void sendCommand(String c) {
        shellStream.print(c + "\n");
        shellStream.flush();
    }
}