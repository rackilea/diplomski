public class ImagePanel extends Panel {
    private static final long serialVersionUID = 1L;
    /**
     * @param id
     */
    public ImagePanel(String id, ResourceReference image) {
        super(id);
        add(new Image("status", image));
    }
}