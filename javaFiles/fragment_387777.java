public class YourController extends Controller {

private final MailerClient mailer ;

    @Inject
    public EventUser(MailerClient mailer) {
        this.mailer = mailer;
    }

public Result Email()
    {
        sendMail("Donald.Trump@gmail.com");
        return ok("done");
    }


private void sendMail(String userEmail)
    {

        Email email = new Email()
                .setSubject("BLah Blah Messsage ")
                .setFrom("")
                .addTo(" <"+userEmail+">")
                // adds attachment
                .setBodyText("Please register to Event at ");
        //.setBodyHtml("<html><body><p>An <b>html</b> message with cid <img src=\"cid:" + cid + "\"></p></body></html>");
        if(mailer!=null)
            mailer.send(email);
    }

}