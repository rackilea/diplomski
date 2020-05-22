public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    shell.setText("StackOverflow");

    final RoundedLabel label = new RoundedLabel(shell, SWT.NONE);
    label.setText("This is a label");

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

private static class RoundedLabel extends Canvas
{
    private String           text   = "";
    private static final int MARGIN = 3;

    public RoundedLabel(Composite parent, int style)
    {
        super(parent, style);

        addPaintListener(new PaintListener()
        {
            @Override
            public void paintControl(PaintEvent e)
            {
                RoundedLabel.this.paintControl(e);
            }
        });
    }

    void paintControl(PaintEvent e)
    {
        Point rect = getSize();
        e.gc.fillRectangle(0, 0, rect.x, rect.x);
        e.gc.drawRoundRectangle(MARGIN, MARGIN, rect.x - 2 * MARGIN - 1, rect.y - 2 * MARGIN - 1, MARGIN, MARGIN);
        e.gc.drawText(text, 2 * MARGIN, 2 * MARGIN);
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
        redraw();
    }

    @Override
    public Point computeSize(int wHint, int hHint, boolean changed)
    {
        GC gc = new GC(this);

        Point pt = gc.stringExtent(text);

        gc.dispose();

        return new Point(pt.x + 4 * MARGIN, pt.y + 4 * MARGIN);
    }
}