public static void main(String[] args)
{
    Display display = new Display();

    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Browser browser = new Browser(shell, SWT.NONE);

    String url = "start.html";
    try
    {
        URI uri = new File(url).toURI();
        URL urls = uri.toURL();
        browser.setUrl(urls.toString());
    }
    catch (MalformedURLException e)
    {
        e.printStackTrace();
    }

    shell.pack();
    shell.setSize(400, 300);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }

    display.dispose();
}