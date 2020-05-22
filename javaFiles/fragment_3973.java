public static class MyButton {

    private final Button buttonEnabled;
    private final Button buttonDisabled;

    private final Composite stackComposite;
    private final StackLayout stackLayout;

    public MyButton(final Composite parent, final String text) {
        stackComposite = new Composite(parent, SWT.NONE);
        stackLayout = new StackLayout();
        stackComposite.setLayout(stackLayout);
        stackComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        buttonEnabled = createButton(stackComposite, text, true);
        buttonDisabled = createButton(stackComposite, text, false);

        stackLayout.topControl = buttonEnabled;
    }

    public void setEnabled(final boolean enabled) {
        stackLayout.topControl = enabled ? buttonEnabled : buttonDisabled;
        stackComposite.layout();
    }

    public boolean isEnabled() {
        return stackLayout.topControl.equals(buttonEnabled) ? true : false;
    }

    private static Button createButton(final Composite parent,
            final String text, final boolean enabled) {
        final Button button = new Button(parent, SWT.PUSH | SWT.FLAT);
        button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        button.setText(text);
        button.setEnabled(enabled);
        if (enabled) {
            button.setImage(parent.getDisplay().getSystemImage(SWT.ICON_ERROR));
        }
        return button;
    }

}