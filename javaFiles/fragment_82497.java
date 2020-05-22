public class MaskeSection {
    private Group myGroup;
    private Button myButton;

    public MaskeSection(Group part) {
        myGroup = new Group(part, SWT.NONE);
        myButton = new Button(myGroup, SWT.RADIO);
        myButton.setEnabled(false);
    }

    public void setPRBS(boolean selected) {
        myButton.setSelection(selected);
    }
}