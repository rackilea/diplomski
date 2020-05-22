package fr.thales.edf.reportEmailAcrAcq.email;

    import java.io.IOException;

    import org.apache.log4j.Level;
    import org.apache.log4j.Logger;

    public class SendHTMLEmail {
        private static final String SENDMAIL = "sendmail -R hdrs -N never -t -v < ";
        private static final Logger LOGGER = Logger.getLogger(SendHTMLEmail.class
                .getName());

        private String fileName;

        public SendHTMLEmail(String fileName) {
            this.fileName = fileName;
        }

        public void sendMail() {
            String command = SENDMAIL + fileName;
            try {
                Runtime r = Runtime.getRuntime();
                LOGGER.log(Level.INFO, "Envoi de la commande: " + command);
                Process p = r.exec(new String[]{"/usr/bin/ksh", "-c", command});
                p.waitFor();
                LOGGER.log(Level.INFO,
                        "Résultat de l'envoi de l'e-mail : " + p.getOutputStream());
            } catch (InterruptedException ex) {
                LOGGER.log(Level.FATAL, ex.getMessage());
            } catch (IOException ex) {
                LOGGER.log(Level.FATAL, ex.getMessage());
            }

        }
    }