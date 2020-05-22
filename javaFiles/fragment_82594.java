public class SendEmailUtility 
    {
       private static Properties props;

      private static Properties getProperties() {
       if (props == null) {
        File configDir = new File(System.getProperty("catalina.base"), "conf");
        File configFile = new File(configDir, "email.properties");
        InputStream stream = new FileInputStream(configFile);
        props = new Properties();
        props.load(stream);
    }
    return props; 
    }
    public static String sendmail(String sendemalto,String generatedpwd) throws  IOException {
        String result = "fail";
        Properties props_load = getProperties();
        final String username = props_load.getProperty("username");
        final String password = props_load.getProperty("password");
        Properties props_send = new Properties();
        props_send.put("mail.smtp.auth","true");
        props_send.put("mail.smtp.starttls.enable","true");
                Transport.send(message);
          // Some code to send email
            result = "success";
        } catch (MessagingException e) {
            result = "fail";
            e.printStackTrace();
        }
        return result;
    }

}