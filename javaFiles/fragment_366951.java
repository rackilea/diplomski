public class MyDialog extends Dialog
{

    protected MyDialog(Shell parentShell) {
        super(parentShell);
    }

    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("test");
        newShell.setSize(200, 100);
    }

    protected void createButtonsForButtonBar(Composite parent) {
    }

    protected Control createDialogArea(Composite parent) {
        Composite content = (Composite) super.createDialogArea(parent);
        content.setLayout(new FillLayout());

        ScrolledComposite sc = new ScrolledComposite(content, SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.BORDER);

        Composite composite = new Composite(sc, SWT.NONE);
        composite.setLayout(new FillLayout(SWT.VERTICAL));

        new Label(composite, SWT.NONE).setText("1111");
        new Label(composite, SWT.NONE).setText("2222");
        new Label(composite, SWT.NONE).setText("3333");
        new Label(composite, SWT.NONE).setText("4444");
        new Label(composite, SWT.NONE).setText("5555");
        new Label(composite, SWT.NONE).setText("6666");
        new Label(composite, SWT.NONE).setText("7777");

        sc.setContent(composite);
        sc.setExpandHorizontal(true);
        sc.setExpandVertical(true);
        sc.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        return parent; 
      }
}