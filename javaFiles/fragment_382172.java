import java.awt.Color;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailTestHTML
{
public static void main(String [] args)
{

   // Recipient's email ID needs to be mentioned.
   String to = "targetemail@somehost.com";

   // Sender's email ID needs to be mentioned
   String from = "youremail@somehost.com";

   // Assuming you are sending email from localhost
   String host = "putYourSMTPHostHere";

   // Get system properties
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   // String with body Text
   String bodyText = addColor("This line is red.", Color.RED);
   bodyText += "<br>" + addColor("This line is blue.", Color.BLUE);
   bodyText += "<br>" + addColor("This line is black.", Color.BLACK);

   System.out.println(bodyText);

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("This is the Subject Line!");

      // Send the actual HTML message, as big as you like
      message.setContent(bodyText,
                         "text/html" );

      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
}

public static String addColor(String msg, Color color) {
    String hexColor = String.format("#%06X",  (0xFFFFFF & color.getRGB()));
    String colorMsg = "<FONT COLOR=\"#" + hexColor + "\">" + msg + "</FONT>";
    return colorMsg;
}
}