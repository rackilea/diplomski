import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestingCat extends JPanel{


JFrame frame =new JFrame();
JPanel panel =new JPanel();
private int flag=0;



JButton enter =new JButton("Enter");
JButton wordBtn =new JButton("Cat");

JTextField tb =new JTextField();




public TestingCat() {


// Panel and button layout

panel.setLayout(null);
panel.setBackground(Color.WHITE);
panel.setCursor( new Cursor(Cursor.HAND_CURSOR) ); // set the cursor to a hand

Insets insets = panel.getInsets();

tb.setVisible(true);
tb.setBounds(200 + insets.left, 5 + insets.top, 110,60);
tb.setBackground(Color.YELLOW);


enter.setLayout(null);
enter.setBounds(10 + insets.left, 5 + insets.top, 110,60);
enter.setBackground(Color.WHITE);
enter.setBorder(BorderFactory.createEmptyBorder());
enter.setFocusPainted( false );

wordBtn.setLayout(null);
wordBtn.setBounds(10 + insets.left, 70 + insets.top, 110,60);
wordBtn.setBackground(Color.WHITE);
wordBtn.setBorder(BorderFactory.createEmptyBorder());
wordBtn.setFocusPainted( false );


panel.add(tb);
panel.add(enter);
panel.add(wordBtn);
frame.add(panel);
frame.setTitle("Matching");
frame.setSize(800, 600);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
frame.setVisible(true);



 // This is where i did the action listener
 wordBtn.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent ae)

{
flag=1;
}

} );

 enter.addActionListener(new ActionListener(){
 public void actionPerformed(ActionEvent ae)
{

JFrame f=new JFrame();
if( ae.getSource().equals(enter) )
    {
      if(flag==1) 
       {
          flag=0;
   if(tb.getText().equals("cat")){
             tb.setText("Correct");
       }
   }
      else
          JOptionPane.showMessageDialog(f,"enter cat 1st");
}

}
});


}


public static void main(String[] args) {
new TestingCat();
}
}