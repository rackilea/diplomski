public class Stackoverflow
{
  public static void main(final String args [])
  {
    Display.setAppName("Stackoverflow");
    final Display display = new Display();
    final Shell shell = new Shell(display);

    shell.setSize(500, 400);
    shell.setLayout(new FillLayout());

    final Composite composite = new Composite(shell, SWT.BORDER);
    composite.setLayout(new GridLayout());

    final Browser browser = new Browser(composite, SWT.NONE);
    browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final Button finish = new Button(composite, SWT.PUSH);
    finish.setText("Finish");
    finish.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

    browser.setUrl("google.com");

    final FocusListener listener = new FocusListener()
      {
        public void focusLost(final FocusEvent arg0)
        {
        }


        public void focusGained(final FocusEvent arg0)
        {
          System.out.println("FocusGained");
          finish.setEnabled(true);
        }
      };
    browser.addFocusListener(listener);

    shell.open();

    while (!shell.isDisposed())
      {
        if (!display.readAndDispatch())
          display.sleep();
      }
    display.dispose();
  }
}