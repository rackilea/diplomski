public class ImageProperty {

    private File source;
    private Dimension size;
    private boolean selected;

    public ImageProperty(File source, Dimension size, boolean selected) {
        this.source = source;
        this.size = size;
        this.selected = selected;
    }

    public Dimension getSize() {
        return size;
    }

    public File getSource() {
        return source;
    }

    public boolean isSelected() {
        return selected;
    }

}