@Creatable
@Singleton
public final class StatusLineManager
{
  /** Label control to show the status */
  private Label _label;

  public StatusLineManager()
  {
  }

  void setLabel(Label label)
  {
    _label = label;
  }

  public void setText(String text)
  {
    if (_label != null && !_label.isDisposed())
      _label.setText(text);
  }
}