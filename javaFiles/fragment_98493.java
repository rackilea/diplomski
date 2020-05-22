public class CustomCell extends AbstractCell<ColumnObject> {
    @Override
    public void render(Context context, ColumnObject value, SafeHtmlBuilder sb) {
        if (showImageFor(value)) {
            // Render the image
        }
    }
}