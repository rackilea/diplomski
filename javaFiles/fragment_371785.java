import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class ConcurrentClickPage extends WebPage {

    public ConcurrentClickPage() {
        final IModel<String> model = new Model<String>("initial");
        Label status = new Label("status", model);
        add(status);
        add(new Link("link1"){
            @Override
            public void onClick() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConcurrentClickPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.setObject("link 1 clicked");
            }
        });
        add(new Link("link2"){
            @Override
            public void onClick() {
                model.setObject("link 2 clicked");
            }
        });
    }

}