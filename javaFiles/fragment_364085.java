public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    StyledText one = new StyledText(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
    StyledText two = new StyledText(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);

    one.setAlwaysShowScrollBars(true);
    two.setAlwaysShowScrollBars(true);

    one.setText("Scroll scroll scroll\ndown down down\nto to to\nsee see see\nthe the the\nstyled styled styled\ntexts texts texts\nscroll scroll scroll\nin in in\ntandem tandem tandem");
    two.setText("Scroll scroll scroll\ndown down down\nto to to\nsee see see\nthe the the\nstyled styled styled\ntexts texts texts\nscroll scroll scroll\nin in in\ntandem tandem tandem");

    handleVerticalScrolling(one, two);
    handleHorizontalScrolling(one, two);

    shell.pack();
    shell.setSize(200, 100);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static void handleHorizontalScrolling(StyledText one, StyledText two)
{
    ScrollBar hOne = one.getHorizontalBar();
    ScrollBar hTwo = two.getHorizontalBar();

    hOne.addListener(SWT.Selection, e -> {
        int x = one.getHorizontalPixel();
        two.setHorizontalPixel(x);
    });
    hTwo.addListener(SWT.Selection, e -> {
        int x = two.getHorizontalPixel();
        one.setHorizontalPixel(x);
    });
}

private static void handleVerticalScrolling(StyledText one, StyledText two)
{
    ScrollBar vOne = one.getVerticalBar();
    ScrollBar vTwo = two.getVerticalBar();

    vOne.addListener(SWT.Selection, e ->
    {
        int y = one.getTopPixel();
        two.setTopPixel(y);
    });
    vTwo.addListener(SWT.Selection, e ->
    {
        int y = two.getTopPixel();
        one.setTopPixel(y);
    });
}