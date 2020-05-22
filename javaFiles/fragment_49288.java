public class DragListener extends MouseInputAdapter implements UIBuilderListener {

    Point location;
    private UIBuilder uiBuilder;
    private Component selectedComponent;

    public DragListener(UIBuilder ui) {
        this.uiBuilder = ui;
        ui.addBuilderListener(this);
    }

    public void mousePressed(MouseEvent me) {
        selectedComponent = me.getComponent();
    }

    @Override
    public void componentTextDidChange(ComponentTextEvent evt) {
        if (selectedComponent instanceof JButton) {
            JButton btn = (JButton) selectedComponent;
            btn.setText(evt.getText());
        }
    }

    @Override
    public void componentNameDidChange(ComponentTextEvent evt) {
        if (selectedComponent instanceof JButton) {
            JButton btn = (JButton) selectedComponent;
            btn.setName(evt.getText());
        }
    }

}