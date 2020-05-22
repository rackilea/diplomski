public class DropZone extends Panel {
    private static final ResourceReference JS_DROP = new JavaScriptResourceReference(DropZone.class, "drop.js");
    private static final ResourceReference CSS_DROP = new CssResourceReference(DropZone.class, "drop.css");
    private static final ResourceReference JQUERY = new JavaScriptResourceReference(DropZone.class, "jQuery.js");
    private static final ResourceReference JQUERY_UI = new JavaScriptResourceReference(DropZone.class, "jQuery-ui.js");

    private static final String ID_DROPZONE = "drop-container";

    /**
     * Constructor
     * 
     * @param id String The component id
     * @param height int The height of the DropZone component [in pixels]
     * @param width int The width of the DropZone component [in pixels]
     */
    public DropZone(String id, int width, int height) {
        super(id);
        final WebMarkupContainer dropZone = new WebMarkupContainer(ID_DROPZONE);
        final DropAjaxBehavior dropAjaxBehavior = new DropAjaxBehavior();

        dropZone.add(dropAjaxBehavior);
        dropZone.add(new AttributeModifier("style", new Model<String>("width:" + width + "px;height:" + height + "px;")));

        add(dropZone);
    }

    @Override
    public final void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        // Important to add jQuery before own javascript
        response.render(JavaScriptHeaderItem.forReference(JQUERY));
        response.render(JavaScriptHeaderItem.forReference(JQUERY_UI));
        response.render(JavaScriptHeaderItem.forReference(JS_DROP));
        response.render(CssContentHeaderItem.forReference(CSS_DROP));
    }
}