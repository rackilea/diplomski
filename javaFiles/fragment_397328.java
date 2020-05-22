public class MyCustomPane extends JScrollPane {
    Container outerContainer;

    public MyCustomPane(Component view) {
        super(view);
    }

    public void setOuterContainer(Container outerContainer) {
        this.outerContainer = outerContainer;
    }

    private Dimension getCustomDimensions() {
        if (outerContainer == null) {
            return new Dimension(0, 0);
        }
        return new Dimension(outerContainer.getWidth() - 10, 60); //10 pixels less than container width, arbitrary height
    }
    @Override
    public Dimension getMaximumSize() {
        return getCustomDimensions();
    }
    @Override
    public Dimension getMinimumSize() {
        return getCustomDimensions();
    }
    @Override
    public Dimension getPreferredSize() {
        return getCustomDimensions();
    }
}