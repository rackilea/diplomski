public class ComposedComposite extends Composite {
    public ComposedComposite(Composite parent, Control... children) {
        super(parent, SWT.NONE);
        for (Control child : children) {
            child.setParent(this);
        }
    }

    public void addChild(Control c) {
        c.setParent(this);
    }
}