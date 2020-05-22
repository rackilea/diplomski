public class TextWithSuffixExample {

    public class TextWithSuffix {

        public TextWithSuffix(final Composite parent) {
            // The border gives the appearance of a single component
            final Composite baseComposite = new Composite(parent, SWT.BORDER);
            baseComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
            final GridLayout baseCompositeGridLayout = new GridLayout(2, false);
            baseCompositeGridLayout.marginHeight = 0;
            baseCompositeGridLayout.marginWidth = 0;
            baseComposite.setLayout(baseCompositeGridLayout);

            // You can set the background color and force it on 
            // the children (the Text and Label objects) to add 
            // to the illusion of a single component
            baseComposite.setBackground(new Color(parent.getDisplay(), new RGB(255, 255, 255)));
            baseComposite.setBackgroundMode(SWT.INHERIT_FORCE);

            final Text text = new Text(baseComposite, SWT.SINGLE | SWT.RIGHT);
            text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

            final Label label = new Label(baseComposite, SWT.NONE);
            label.setEnabled(false);
            label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true));
            label.setText("kg/m^3");
        }

    }

    final Display display;
    final Shell shell;

    public TextWithSuffixExample() {
        display = new Display();
        shell = new Shell(display);
        shell.setLayout(new GridLayout());
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new TextWithSuffix(shell);
    }

    public void run() {
        shell.setSize(200, 100);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    public static void main(final String[] args) {
        new TextWithSuffixExample().run();
    }

}