JFrame frame = new JFrame("title");
JPanel  panel = new JPanel();
JButton button = new JButton("Close");

//You need this for the screen to show.
frame.setSize(width,height);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
frame.setLocationRelativeTo(null);


//add the panel to the frame and the button to the panel 
frame.add(panel);
panel.add(button);
button.addActionListener(this);//the class needs to implements ActionListener

frame.setVisible(true);

//this is the actionperformed method which will run if the button is clicked.
public void actionPerformed(ActionEvent e) {
      if(e.getSource==button){//If you have more than one button.
          System.exit(0);
      }
}