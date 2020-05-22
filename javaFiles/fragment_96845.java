private static Display  display = Display.getDefault();
private static Composite[]  cells  = new Composite[6];
private static Color[] colors = new Color[6];

private static Random   random  = new Random(System.currentTimeMillis());

private static PaintListener listener  = new PaintListener()
{
    @Override
    public void paintControl(PaintEvent e)
    {
        Rectangle rect = ((Canvas) e.widget).getBounds();
        e.gc.setBackground(colors[random.nextInt(colors.length)]);
        e.gc.fillRectangle(5, 5, rect.width - 10, rect.height - 10);
    }
};

static
{
    int i = 0;
    colors[i++] = display.getSystemColor(SWT.COLOR_BLACK);
    colors[i++] = display.getSystemColor(SWT.COLOR_RED);
    colors[i++] = display.getSystemColor(SWT.COLOR_BLUE);
    colors[i++] = display.getSystemColor(SWT.COLOR_GREEN);
    colors[i++] = display.getSystemColor(SWT.COLOR_YELLOW);
    colors[i++] = display.getSystemColor(SWT.COLOR_GRAY);
}

public static void main(String[] args)
{
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(3, true));

    for (int i = 0; i < 6; i++)
    {
        Composite comp = new Composite(shell, SWT.NONE);
        comp.setLayout(new GridLayout(2, false));
        Canvas canvas = new Canvas(comp, SWT.NONE);
        canvas.addPaintListener(listener);
        Label text = new Label(comp, SWT.NONE);
        String textString = "";
        for(int j = 0; j < random.nextInt(10); j++)
            textString += "A";

        text.setText(textString);

        cells[i] = comp;
    }

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Random");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            for (int i = 0; i < 6; i++)
            {
                Composite cell = cells[i];
                for(Control child : cell.getChildren())
                    child.dispose();

                Canvas canvas = new Canvas(cell, SWT.NONE);
                canvas.addPaintListener(listener);

                Label text = new Label(cell, SWT.NONE);
                String textString = "";
                for(int j = 0; j < random.nextInt(10); j++)
                    textString += "A";

                text.setText(textString);
            }

            shell.layout(true,  true);
            shell.pack();
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}