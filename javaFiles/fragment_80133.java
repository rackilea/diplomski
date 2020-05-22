public class InputDialogWithNote extends InputDialog
{
  private Label noteLabel;

  public InputDialogWithNote(final Shell parentShell, final String dialogTitle, final String dialogMessage, final String initialValue, final IInputValidator validator)
  {
    super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
  }

  @Override
  protected Control createDialogArea(final Composite parent)
  {
    Composite body = (Composite)super.createDialogArea(parent);

    noteLabel = new Label(body,  SWT.LEAD);
    noteLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    return body;
  }
}