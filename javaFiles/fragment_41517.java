/**
 * Behavior that traps the enter key press
 *
 * @author ivaynberg
 */
public class EnterKeyTrap extends Behavior implements IHeaderContributor {

    private static final long serialVersionUID = -410239548482332706L;

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        tag.put("onkeydown", "return ekt(event)!=13");
    }

    public void renderHead(IHeaderResponse response) {
        response.renderJavaScript("function ekt(e){if(typeof(e.keyCode)==\"undefined\"){return e.which;}else{return e.keyCode;}}", "EnterKeyTrap");
    }

}