package Main;
import UI.Accordiontest;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class test extends Application {

    private SplitPanel horizontalSplit = new SplitPanel(
            SplitPanel.ORIENTATION_HORIZONTAL);
    private Accordiontest accordion = new Accordiontest();

    public void init() {
        buildMainLayout();
    }


    private void buildMainLayout () {
// No more casting errors because accordion extends Accordion which is component
        horizontalSplit.setFirstComponent(accordion);

        setMainWindow(new Window("test))'
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.addComponent(horizontalSplit);
        layout.setExpandRatio(horizontalSplit, 1);
        getMainWindow().setContent(layout);
    }
 }