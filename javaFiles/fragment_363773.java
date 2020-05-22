public class MyDialog extends Dialog
{
    public static void main(String[] args)
    {
        new MyDialog(new Shell()).open();
    }

    public MyDialog(Shell parentShell)
    {
        super(parentShell);
        setShellStyle(SWT.RESIZE | SWT.DIALOG_TRIM);
    }

    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite container = (Composite) super.createDialogArea(parent);
        getShell().setMinimumSize(400, 300);

        new Button(container, SWT.PUSH).setText("Some content here");

        return container;
    }
}