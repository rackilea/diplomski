public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    ScrolledComposite listPanel = new ScrolledComposite(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
    listPanel.setLayout(new GridLayout(1, false));

    Composite child = new Composite(listPanel, SWT.NONE);
    child.setLayout(new GridLayout(2, false));

    for (int i = 1; i < 10; i++)
    {
        Button button = new Button(child, SWT.PUSH);
        button.setText("lalala");

        Label label = new Label(child, SWT.BORDER);
        label.setText(i + "     foo");
    }

    Point size = child.computeSize(SWT.DEFAULT, SWT.DEFAULT);

    listPanel.setContent(child);
    listPanel.setMinSize(size.x, size.y);
    listPanel.setExpandHorizontal(true);
    listPanel.setExpandVertical(true);

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}