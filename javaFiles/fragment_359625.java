public class StickyModel extends JToggleButton.ToggleButtonModel {

    public void reset() {
        super.setSelected(false);
    }

    @Override
    public void setSelected(boolean b) {
        if (!isSelected()) {
            super.setSelected(b);
        }
    }

}