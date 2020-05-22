public class SampleWindow {

    protected Shell shell;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        try {
            SampleWindow window = new SampleWindow();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setSize(531, 363);
        shell.setText("SWT Application");

        Composite composite = new Composite(shell, SWT.BORDER);
        composite.setBounds(10, 10, 131, 304);
        composite.setLayout(new FillLayout(SWT.HORIZONTAL));

        Label lblNewLabel = new Label(composite, SWT.NONE);
        lblNewLabel.setText("Fill Layout");

        Composite composite_1 = new Composite(shell, SWT.BORDER);
        composite_1.setBounds(159, 10, 199, 304);
        composite_1.setLayout(new GridLayout(3, false));
        Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
        lblNewLabel_1.setText("Grid Layout");

        Composite composite_2 = new Composite(shell, SWT.BORDER);
        composite_2.setBounds(382, 10, 123, 304);
        composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));

        Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
        lblNewLabel_2.setText("Fill Layout");

    }
}