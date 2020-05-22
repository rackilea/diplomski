// your constructor:
public GUI() {
  super("MusicList - Alpha");
  setLayout(null);  // **** ugh, don't do this ****
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // **** added ****

  jl = new JList(m);
  add(jl);
  // creates a scrollpane, "implements jlist"
  sp = new JScrollPane(jl);
  sp.setBounds(30, 30, 195, 200);
  add(sp);
  // creates the textfield to contain songname


  // ...... etc ...... code abbreviated for sake of clarity


  songl = new JLabel("Song");
  songl.setBounds(20, 10, 170, 20);
  add(songl);
  songl.setVisible(false);

  //  ****** I've added this code below *****
  int timerDelay = 2000;
  new Timer(timerDelay, new ActionListener() {
     private String[] menuValues = {"0", "1", "2"};
     private int index = 0;

     @Override
     public void actionPerformed(ActionEvent evt) {
        changeMenu(menuValues[index]);
        System.out.println("Index: " + index);
        index++;
        index %= menuValues.length;
     }
  }).start();
}