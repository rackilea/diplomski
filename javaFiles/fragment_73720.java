public static void main(String[] args) {
    final Shell shell = new Shell();
    shell.setLayout(new FillLayout());

    TitleAreaDialog dialog = new MyTitleAreaDialog(shell);
    dialog.setTitleAreaColor(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND).getRGB());
    dialog.open();
}

private static class MyTitleAreaDialog extends TitleAreaDialog
{
    private Image image;

    public MyTitleAreaDialog(Shell parentShell) {
        super(parentShell);
        image = new Image(Display.getDefault(), "/home/baz/Desktop/StackOverflow.png");
    }

    @Override
    public boolean close() {
        if (image != null)
            image.dispose();
        return super.close();
    }

    @Override
    protected Control createContents(Composite parent) {
        Control contents = super.createContents(parent);

        setTitle("Title");
        setMessage("Message");

        if (image != null)
            setTitleImage(image);

        return contents;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        // YOUR LINE HERE!
        Label line = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
        line.setLayoutData(new GridData(SWT.FILL, SWT.END, true, true));

        return composite;
    }
}