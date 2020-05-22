import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.goulds.client.views.ApplicationEntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestMTextBox extends ApplicationEntryPoint
{
    private class MTextBox extends TextArea {
        public MTextBox() {
            super();
            this.addDomHandler(new BlurHandler(){
                @Override
                public void onBlur(BlurEvent event) {
                    //Handle Blur
                    GWT.log("onBlur");
                }           
            }, BlurEvent.getType());
            this.addDomHandler(new FocusHandler(){
                @Override
                public void onFocus(FocusEvent event) {
                    // Handle Focus.
                    GWT.log("onFocus");
                }           
            }, FocusEvent.getType());
        }
    }



    @Override
    public void onModuleLoad()
    {
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(new MTextBox());
        verticalPanel.add(new MTextBox());
        verticalPanel.add(new MTextBox());


        RootPanel.get().add(verticalPanel);
    }
}