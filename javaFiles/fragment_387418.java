public static void main(String[] args)
{
    final Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    GC gc = new GC(display);

    System.out.println(gc.textExtent("Hi").y);

    gc.dispose();

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}