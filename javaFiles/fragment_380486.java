package javaapplication7;

 /**
  *
  * @author imran
  */
 import java.awt.*;
 import java.awt.event.*;
 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.IOException;

 import javax.swing.*;
 class MobileHome extends JFrame implements ActionListener {


 final String card1Text = "Card 1";
 final String card2Text = "Card 2";
 final String card3Text = "Card 3";
 final JPanel cards; //a panel that uses CardLayout
 // button commands
 final String FIRST = "FIRST";
 final String NEXT = "NEXT";
 final String PREVIOUS = "PREVIOUS";
 final String LAST = "LAST";


  File file = new   File("C:/Users/imran/Desktop/JavaApplication7/src/javaapplication7/mobile.txt");
 BufferedReader reader  = null;
 public String read()
{
String savetext = "";

try{
reader = new BufferedReader(new FileReader(file));
String text = null;


while((text = reader.readLine()) != null){


    final String LS = System.getProperty("line.separator");
    savetext += text + LS;  

    }

}
 catch(IOException jim){
jim.printStackTrace();
 }
 return savetext;
}


/*public void actionPerformed(ActionEvent e) {
 CardLayout cl = (CardLayout) (cards.getLayout());
 String cmd = e.getActionCommand();
 if (cmd.equals(FIRST)) {
     cl.first(cards);
 } else if (cmd.equals(NEXT)) {
     cl.next(cards);
 } else if (cmd.equals(PREVIOUS)) {
     cl.previous(cards);
 } else if (cmd.equals(LAST)) {
     cl.last(cards);
 }
 }*/
 JButton saveOne = new JButton("Save to file");

 JTextArea mobOneText = new JTextArea("TextField on Card 1", 15, 20);




  public MobileHome() {



   super("Mobile Wizard");

  //Create the "cards".
   JPanel card1 = new JPanel();

   card1.add(saveOne);
   saveOne.addActionListener(this);

   card1.add(mobOneText);
   mobOneText.setText(read());




card1.setBackground(new Color(255,0,0));




   JPanel card2 = new JPanel();
   card2.add(new JTextField("TextField on Card 2", 20));
   card2.setBackground(new Color(0,255,0));

   JPanel card3 = new JPanel();
   card3.add(new JLabel("Card 3"));
   card3.setBackground(new Color(0,0,255));

   //Create the panel that contains the "cards".
   cards = new JPanel(new CardLayout());
   cards.add(card1, card1Text);
   cards.add(card2, card2Text);
   cards.add(card3, card3Text);






JButton btn1 = new JButton("First");
btn1.setActionCommand(FIRST);
btn1.addActionListener(this);

JButton btn2 = new JButton("Next");
btn2.setActionCommand(NEXT);
btn2.addActionListener(this);

JButton btn3 = new JButton("Previous");
btn3.setActionCommand(PREVIOUS);
btn3.addActionListener(this);

JButton btn4 = new JButton("Last");
btn4.setActionCommand(LAST);
btn4.addActionListener(this);

JPanel controlButtons = new JPanel();
controlButtons.add(btn1);
controlButtons.add(btn2);
controlButtons.add(btn3);
controlButtons.add(btn4);

ImageIcon img = new ImageIcon("hand.jpg");
setIconImage(img.getImage());

Container pane = this.getContentPane();
pane.add(cards, BorderLayout.CENTER);
pane.add(controlButtons, BorderLayout.PAGE_END);



setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(300, 200);
setVisible(true);
}
public void actionPerformed(ActionEvent f) {

 System.out.println("hi");
  CardLayout cl = (CardLayout) (cards.getLayout());
 String cmd = f.getActionCommand();
 if (cmd.equals(FIRST)) {
     cl.first(cards);
 } else if (cmd.equals(NEXT)) {
     cl.next(cards);
 } else if (cmd.equals(PREVIOUS)) {
     cl.previous(cards);
 } else if (cmd.equals(LAST)) {
     cl.last(cards);
 }
if (f.getSource().equals(saveOne)) {
    try {
        System.out.println("hello");
        BufferedWriter fileOut = new BufferedWriter(new FileWriter("filename.txt")); 
        String myString1 =mobOneText.getText();
        String myString2 = mobOneText.getText();

        System.out.println(myString2);

        fileOut.write(myString1);
        fileOut.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}

}
 public static void main(String[] args) {
     new MobileHome();
 }
}