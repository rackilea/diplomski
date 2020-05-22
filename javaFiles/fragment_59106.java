import play.libs.Akka;
import scala.concurrent.duration.Duration;
import java.util.concurrent.TimeUnit;

public static void sendRegistrationMail(String userName, String firstName, String surname, String registrationDate, String emailToken) {
    Akka.system().scheduler().scheduleOnce(
        Duration.create(10, TimeUnit.MILLISECONDS),
        new Runnable() {
            public void run() {
                MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
                mail.setSubject("Welcome!");
                mail.setRecipient(userName);
                mail.setBcc("***@*****.com");
                mail.setFrom("Welcome");
                String body = views.html.emails.registration.render(userName, firstName, surname, registrationDate, emailToken).body();
                mail.sendHtml(body);
            }
        },
        Akka.system().dispatcher()
    );
}