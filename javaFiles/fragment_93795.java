public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final ScrolledComposite composite = new ScrolledComposite(shell, SWT.V_SCROLL);
    composite.setLayout(new FillLayout());

    List list = new List(composite, SWT.NONE);

    for (int i = 0; i < 20; i++)
    {
        list.add("Item: " + i);
    }

    composite.setContent(list);
    composite.setExpandHorizontal(true);
    composite.setExpandVertical(true);
    composite.setMinSize(list.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    list.setEnabled(false);

    shell.pack();
    shell.setSize(100, 150);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}