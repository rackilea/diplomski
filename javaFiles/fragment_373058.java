public class InputMethodTest {

  public static void main(String[] args) {
    final InputContext en = InputContext.getInstance();
    en.selectInputMethod(Locale.UK);
    final InputContext es = InputContext.getInstance();
    es.selectInputMethod(new Locale("es", "ES"));
    JTextArea english = new JTextArea() {
      @Override
      public InputContext getInputContext() {
        return en;
      }
    };
    JTextArea spanish = new JTextArea() {
      @Override
      public InputContext getInputContext() {
        return es;
      }
    };

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new GridLayout());
    frame.getContentPane().add(new JScrollPane(english));
    frame.getContentPane().add(new JScrollPane(spanish));
    frame.setSize(600, 400);
    frame.setVisible(true);
  }
}