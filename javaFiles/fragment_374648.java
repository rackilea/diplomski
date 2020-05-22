protected ProgressBar bar;
protected Shell       shell;

public ProgressBox(Shell parent, final String name)
{
    this.shell = new Shell(parent, SWT.APPLICATION_MODAL | SWT.TITLE);
    shell.setLayout(new FillLayout());

    bar = new ProgressBar(shell, SWT.SMOOTH);

    shell.setText(name);
    shell.pack();
    shell.open();
}

public void open()
{
    final int max = 10;

    this.bar.setMaximum(max);

    new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            for (int i = 1; i <= max; i++)
            {
                if (bar == null || bar.isDisposed())
                {
                    closeShell();
                    return;
                }
                else
                {
                    final int index = i;
                    shell.getDisplay().asyncExec(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            bar.setSelection(index);
                        }
                    });
                }

                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    closeShell();
                    e.printStackTrace();
                }
            }

            closeShell();
        }

        private void closeShell()
        {
            shell.getDisplay().asyncExec(new Runnable()
            {
                @Override
                public void run()
                {
                    shell.close();
                }
            });
        }
    }).start();
}

public static void main(String[] args)
{
    Display display = Display.getDefault();
    Shell shell = new Shell();
    shell.setSize(450, 300);
    shell.open();

    new ProgressBox(shell, "Progress").open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
}