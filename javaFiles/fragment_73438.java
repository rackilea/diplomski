public class MyFrame extends JFrame {
   public MyFrame() {
       JButton but = new JButton("but");
       but.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               QuestionDialog dialog = new QuestionDialog(MyFrame.this);
               dialog.setVisible(true);
           }
       });
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable(){
           public void run() {
               new MyFrame();
           } 
       });
   }
}

public class QuestionDialog extends JDialog {
    public QuestionDialog(Frame parent) {
        super(parent);
    }
}