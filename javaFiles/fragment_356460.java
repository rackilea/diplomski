public static class DisplayQnA extends JDialog {

 JLabel label;
 JTextArea textarea;
 AddQnA qa;

 public DisplayQnA(JFrame frame) {

    super(frame, "Display Question & Answer", true);
    qa = new AddQnA(frame)