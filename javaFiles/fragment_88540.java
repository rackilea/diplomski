public class SomeDialog extends JDialog {

  public SomeDialog() {
    // see other JDialog constructors for other ways to call this
    super(parentWindow, title, ModalityType.DOCUMENT_MODAL);
    ...
  }

}