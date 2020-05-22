import java.io.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class EML {

  public static void main(String args[]) throws Exception {

  String host = "192.168.10.205";
  String from = "test@localhost";
  String to = "test@localhost";

  Properties props = System.getProperties();
  props.setProperty("mail.smtp.host", host);
  props.put("mail.transport.protocol", "smtp");

  Session mailSession = Session.getDefaultInstance(props, null);

  File emlFile = new File("message.eml");
  InputStream source = new FileInputStream(emlFile);

  MimeMessage message = new MimeMessage(mailSession, source);

  System.out.println("Subject : " + message.getSubject());
  System.out.println("From : " + message.getFrom()[0]);
  System.out.println("--------------");
  System.out.println("Body : " + message.getContent());
  }
}