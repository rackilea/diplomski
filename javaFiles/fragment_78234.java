public class BenchUI extends JPanel{

  JPanel one;
  JFrame jf;
  JComboBox<String> clientList;
  String[] moo = {"Goat", "Fish", "Donkey"};

  public BenchUI(JFrame j){
    jf = j;

    one = new JPanel(new GridBagLayout());
    one.setBackground(Color.blue);
    one.setPreferredSize(new Dimension(300,300));

    //clientList = new JComboBox<String>(moo);
    //one.add(clientList);

    add(one);
  }
}