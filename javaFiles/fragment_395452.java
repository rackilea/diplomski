public class FMLDialog extends Dialog
{
    public FMLDialog(Shell parentShell)
    {
        super(parentShell);
    }

    @Override
    protected void configureShell(Shell shell)
    {
        super.configureShell(shell);
        shell.setSize(new Point(700, 500));
        shell.setText("FML");
    }

    @Override
    public Control createDialogArea(final Composite comp)
    {
        Composite content = (Composite) super.createDialogArea(comp);
        content.setLayout(new GridLayout(2, false));
        content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        final ScrolledComposite scroll = new ScrolledComposite(content, SWT.V_SCROLL);
        scroll.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        scroll.setExpandHorizontal(true);
        scroll.setExpandVertical(true);

        Composite optionsPanel = new Composite(scroll, SWT.BORDER);
        optionsPanel.setLayout(new FillLayout(SWT.VERTICAL));
        optionsPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for (int i = 0; i < 200; i++)
        {
            new Label(optionsPanel, SWT.NONE).setText("this is item " + i);
        }

        scroll.setContent(optionsPanel);
        scroll.setMinSize(optionsPanel.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        final Canvas c = new Canvas(content, SWT.BORDER);
        c.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        c.addPaintListener(new PaintListener()
        {
            @Override
            public void paintControl(PaintEvent e)
            {
                Point size = c.getSize();
                e.gc.drawText("Width: " + size.x + "\nHeight: " + size.y, 5, 5);
                e.gc.drawOval(2, 2, size.x - 4, size.y - 4);
            }
        });

        return content;
    }

    public static void main(String[] args)
    {
        Display d = new Display();
        Shell s = new Shell();

        FMLDialog fml = new FMLDialog(s);
        fml.open();
    }
}