class MyMessageDialog extends MessageDialog {
  @Override
  public void create() {
    super.create();
    if( usingBraille ) {
      messageLabel.forceFocus();
    }
  }
}