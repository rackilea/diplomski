public class BrowserDialog extends Dialog {

    private String browserString;

    protected BrowserDialog(Shell parentShell, String browserString) {
        super(parentShell);
        this.browserString = browserString;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        GridLayout layout = new GridLayout(1, false);
        composite.setLayout(layout);

        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.widthHint = 400;
        data.heightHint = 400;
        composite.setLayoutData(data);


        Browser browser = new Browser(composite, SWT.NONE);
        browser.setText(browserString);
        browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        return composite;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("About");
    }

    @Override
    public void okPressed() {
        close();
    }

    public static void main(String[] args)
    {
        final Display display = new Display();
        Shell shell = new Shell(display);

        Color gray = display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);

        String hex = String.format("#%02x%02x%02x", gray.getRed(), gray.getGreen(), gray.getBlue());

        new BrowserDialog(shell, "<body bgcolor='" + hex + "'><h2>TEXT</h2></body>").open();
    }

}