import javax.mail.Transport;
import javax.mail.*;

public class CustomTransport extends Transport {

  public CustomTransport(Session smtpSession, URLName urlName) {
    super(smtpSession, urlName);
  }

  @Override
  public void sendMessage(Message message, Address[] addresses) throws MessagingException {
    // Take the message and write it somewhere
    // e.g.: a logger or an OutputStream message.writeTo(...);
  }

  @Override
  public void connect() throws MessagingException {}

  @Override
  public void connect(String host, int port, String username, String password) throws MessagingException {}

  @Override
  public void connect(String host, String username, String password) throws MessagingException {}

  @Override
  public void close() {}
}