import com.jscape.inet.imap.*;
import com.jscape.inet.email.*;
import com.jscape.inet.imapssl.ImapSsl;
import com.jscape.inet.mime.*;
import java.io.*;

public class ImapSshExample {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

    public void getMessages() throws ImapException, MimeException, IOException {

        ImapSsl imap = new ImapSsl("imap.gmail.com", 993, "username", "password");
        imap.connect();
        int messageCount = imap.getMessageCount();

        for (int i = 1; i <= messageCount; i++) {
            EmailMessage msg = imap.getMessage(i);
            System.out.println("-- begin message --");
            System.out.println(new String(msg.getMessage()));
            System.out.println("-- end message --");

            System.out.print("ENTER for next message or type QUIT to quit: ");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }
        }
        imap.disconnect();
    }

    public static void main(String[] args) {
        try {
            ImapSshExample example = new ImapSshExample();
            example.getMessages();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}