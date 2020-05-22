import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class JSSH {
    private static final String user = "UID"; 
    private static final String password = "pass";

    public static void main(String args[]) throws JSchException,
        InterruptedException, IOException {
    JSSH jssh = new JSSH();
    JSch jsch = new JSch();
    for(String host : jssh.listOfhost()) {
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(password);
        session.setConfig(getProperties());
        session.connect(10 * 1000);
        Channel channel = session.openChannel("shell");

        for(String command : jssh.listOfCommand()) {
            channel.setInputStream(new ByteArrayInputStream(command.getBytes()));
            channel.setOutputStream(new FileOutputStream(new File(OUTPUT_FILE)));
            channel.connect(15 * 1000);
            TimeUnit.SECONDS.sleep(3);
        }

        channel.disconnect();
        session.disconnect();
    }
}

private static Properties getProperties() {
    Properties properties = new Properties();
    properties.put("StrictHostKeyChecking", "no");
    return properties;
}


    private List<String> listOfCommand() throws IOException {
        return new LineBuilder("command_file.txt").build();
    }

    private List<String> listOfhost() throws IOException {
        return new LineBuilder("host_file.txt").build();
    }
}  
}