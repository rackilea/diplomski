public JProgressBar createJP(int input) {
    JProgressBar jp = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
    //jp.setPreferredSize(new Dimension(10, 100));
    //Why do you use PreferedSize if you want the size to be fixed?
    jp.setSize(new Dimension(10, 100));
    jp.setValue(input);  
    jp.setBackground(Color.BLACK);
    setBorderPainted(false);  
    return jp;
  }