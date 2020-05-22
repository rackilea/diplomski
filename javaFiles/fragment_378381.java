import java.awt.*;  
     import javax.swing.*;  

     public class GUITest extends JFrame {

         public GUITest() {

              super("Testing Title");  
              Container pane = getContentPane();  
              pane.setLayout(new BorderLayout());//Modified Layout to BorderLayout  
              pane.add(getHeader(),BorderLayout.NORTH); //BorderLayout.NORTH
              pane.add(getTextArea(),BorderLayout.CENTER);//BorderLayout.CENTER
              pane.add(getButtonPanel(),BorderLayout.SOUTH);//BorderLayout.SOUTH

        }  

         public JComponent getHeader() {  

             JPanel labelPanel = new JPanel();  
             labelPanel.setLayout(new GridLayout(1,2));  
             labelPanel.setSize(getPreferredSize());    
             JLabel labelLocal = new JLabel("Left value: ", JLabel.CENTER);  
             JLabel labelDB = new JLabel("Right value: ", JLabel.CENTER);  
             labelPanel.add(labelLocal);
             labelPanel.add(labelDB);
             return labelPanel;

         }

     public JComponent getTextArea() {  

           JPanel textPanel = new JPanel();    
           textPanel.setLayout(new GridLayout(1,2,5,0));
           JTextArea testTextArea = new JTextArea();
           testTextArea.setEditable(false);
           JScrollPane sp1 = new JScrollPane(testTextArea); 
           JTextArea testTextArea2 = new JTextArea();
           JScrollPane sp2 = new JScrollPane(testTextArea2); 
           testTextArea2.setEditable(false);
           testTextArea.setText("Hello Hello Hello\nTesting!\ntesterino\ntesteroni");
           testTextArea2.setText("Hello Hello Hello\nTesting!\ntest\nABC123\ncdef123\nhijk123");
           textPanel.add(sp1);
           textPanel.add(sp2);
           return textPanel;
   }

     public JComponent getButtonPanel() {

          JPanel inner = new JPanel();
          inner.setLayout(new FlowLayout());//Modified to standard FlowLayout  
          inner.add(new JButton("Do something"));  
          inner.add(new JButton("Do something different"));  
          inner.add(new JButton("Do something even more different"));  
          return inner;  

     }

     public static void main(String[] args) {  

          GUITest e = new GUITest();  
          e.pack(); //Modified setSize(700,500) to pack()  
          e.setVisible(true);  
          e.setResizable(false);  
          e.setDefaultCloseOperation(EXIT_ON_CLOSE);  
          e.setLocationRelativeTo(null);  
     }  
}