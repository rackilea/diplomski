package test;

import import org.apache.commons.mail.*;
   public class Mailer{
   public static void main(String[] args){
    try{
    Email email = new SimpleEmail();
    email.setHostName("smtp.googlemail.com");
    email.setSmtpPort(465);
    email.setAuthenticator("username", "password");
    email.setSSLOnConnect(true);
    email.setFrom("user@gmail.com");
    email.setSubject("TestMail");
    email.setMsg("This is a test mail ... :-)");
    email.addTo("foo@bar.com");
    email.send();
JOptionPane.showConfirmDialog(this, "Email sent succeefully");
}catch(Exception e){
   JOptionPane.showMessageDialog(this,
    e.getMessage(),
    "Error",
    JOptionPane.ERROR_MESSAGE);
}
    }
}