public static void main(String[] args) {

    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));
    shell.setSize(200, 200);
    Button b = new Button(shell, SWT.NONE);
    b.setText("Click");
    b.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {


         CDialog dialog = new CDialog(shell);

         dialog.open();
      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {

        // TODO Auto-generated method stub

      }
    });

    shell.open();



    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }  


  private static class CDialog extends Dialog
  {

    /**
     * @param parentShell
     */
    protected CDialog(Shell parentShell) {

      super(parentShell);
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createDialogArea(Composite parent) {

      Composite comp =  (Composite) super.createDialogArea(parent);

      Label lbl = new Label(comp, SWT.NONE);
      lbl.setText("Test modeless dialog");

      return comp;
    }
    /* (non-Javadoc)
     * @see org.eclipse.jface.window.Window#getShellStyle()
     */
    @Override
    protected int getShellStyle() {
      return SWT.DIALOG_TRIM|SWT.MODELESS;
    }

  }