import akka.actor.UntypedActor;
import play.api.templates.Html;
import views.html.mail;

public class EmailDispatcher extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof DocumentIssuedMailWrapper) {
            DocumentIssuedMailWrapper wrapper = (DocumentIssuedMailWrapper) message;
            Html mailTemplate = mail.render(wrapper.getRequestHeader());
            //sending mail
        }
    }

}