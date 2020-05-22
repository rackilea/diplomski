public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    List<String> input = new ArrayList<>();
    input.add("Dodo");
    input.add("Unicorn");

    final MyFilter filter = new MyFilter();

    final ListViewer viewer = new ListViewer(shell);
    viewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    viewer.setContentProvider(new ArrayContentProvider());
    viewer.setInput(input);
    viewer.addFilter(filter);

    Text text = new Text(shell, SWT.BORDER);
    text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
    text.addListener(SWT.Verify, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            final String oldS = ((Text) e.widget).getText();
            final String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

            filter.setSearchText(newS);
            viewer.refresh();
        }
    });

    shell.pack();
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

private static class MyFilter extends ViewerFilter
{
    private String searchString;

    public void setSearchText(String s)
    {
        this.searchString = ".*" + s + ".*";
    }

    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element)
    {
        if (searchString == null || searchString.length() == 0)
        {
            return true;
        }

        String p = (String) element;

        if (p.matches(searchString))
        {
            return true;
        }

        return false;
    }
}