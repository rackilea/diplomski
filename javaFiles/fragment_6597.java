private static final Color[] colors = new Color[2];

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1,  false));

    Composite content = new Composite(shell, SWT.NONE);
    GridLayout layout = new GridLayout(1, false);
    layout.verticalSpacing = 0;
    content.setLayout(layout);
    content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    colors[0] = display.getSystemColor(SWT.COLOR_DARK_GRAY);
    colors[1] = display.getSystemColor(SWT.COLOR_GRAY);

    for (int i = 0; i < 5; i++)
        createPart(content, i);

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static void createPart(Composite parent, int i)
{
    Composite comp = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout(2, false);
    layout.marginHeight = 0;
    comp.setLayout(layout);
    comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    comp.setBackground(colors[i % 2]);

    Label left = new Label(comp, SWT.NONE);
    left.setText("Left");
    left.setBackground(colors[i % 2]);
    Label right = new Label(comp, SWT.NONE);
    right.setText("Right");
    right.setBackground(colors[i % 2]);
}