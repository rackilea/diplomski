import java.awt.Dimension; 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame; 
import javax.swing.JTextField; 
public class AutoResizeTest 
{      
    public AutoResizeTest(){
        JFrame frame = new JFrame("Auto-Resizable TextField");         
        frame.setLayout(null);

        MyCustomTextField expandableText = new MyCustomTextField(20);
        expandableText.setBounds(10, 10, 200, 30);
        expandableText.setPreferredSize(new Dimension(200,30));
        expandableText.setMaximumSize(new Dimension(600,30));

        frame.add(expandableText);
        frame.setBounds(100,100,700,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {         
        AutoResizeTest test = new AutoResizeTest();
    }      

    class MyCustomTextField extends javax.swing.JTextField{

        private int originallimit;
        int previousLength;
        int length;

        public MyCustomTextField(int limit){

            previousLength=0;
            originallimit = limit;

            this.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) { 

                    JTextField textField = (JTextField) e.getSource();                 
                    length = textField.getText().length();

                    if(length >= originallimit){

                        if(length > previousLength){
                            textField.setSize(new Dimension(textField.getWidth()+10, textField.getHeight()));
                        }
                        else{
                            if(length < previousLength)
                            textField.setSize(new Dimension(textField.getWidth()-10, textField.getHeight()));
                        }
                        previousLength = length;

                    }else{
                        textField.setSize(textField.getPreferredSize());
                    }
                }
            });
        }

    }
}