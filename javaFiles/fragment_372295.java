public class ExamplePanel implements IHeaderContributor {
    public ExamplePanel(String id) {
        super(id);

        add(new Label("someText", "hello"));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        // use this if you want to add only the styles
        response.renderString("<style>#div {position:'relative'; top:'5px'; left='29px';}</style>");

        // or, use this if you still want the JS selector
        // the uniqueId should not be null if you want Wicket to check if the script has already been rendered
        response.renderJavascript("$('#div').css({position:'relative',top:'5px',left='29px'})", null);
    }
}