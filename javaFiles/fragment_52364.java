private Map<JButton, ClassTwo> classTwoMap;

public ClassOne(){
  classTwoMap = new HashMap<JButton, ClassTwo>();
  ClassTwo bn1window = new ClassTwo();
  bn1window .setVisible(false);
  //initialisation code for your window
  .....
  JButton btn = new JButton("Open");
  btn.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
        classTwoMap.Get(e.getSource()).setVisible(true);
     }
  });

  classTwoMap.Get(btn).setvisible(false);
}

//Edit:
public ClassTwo() {
    // This will hide the window when closed, and the button will re-"open" it.
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
}