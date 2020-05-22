public class Bingo extends JPanel{
  private static final long serialVersionUID = -5791572059409665801L;
  private LinkedList<Integer> list = new LinkedList<Integer>();
  private JButton c = new JButton("Call");

  public Bingo(){
    for(int ii=1; ii<= 75; ii++)
      list.add(ii);
    Collections.shuffle(list);

    c.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        System.out.println(list.poll());
      }
    });

    add(c);
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("ButtonDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Bingo bingoClass = new Bingo();
    bingoClass.setOpaque(true);
    frame.setContentPane(bingoClass);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String... args){
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}