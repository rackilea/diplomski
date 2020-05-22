//Override the createPopup method - everything else can stay the same
public static CustomRenderer extends MetalComboBoxUI{
    @Override
    protected ComboPopup createPopup() {
        // Do something different here
        ComboPopup result = super.createPopup();
        return result;
    }
}