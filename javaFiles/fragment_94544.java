import java.awt.*;
import java.applet.*;
import javax.swing.JLabel;

public class Main extends Applet implements Runnable
{
    private static final long serialVersionUID = 1L;
    Thread thread1, thread2, thread3, thread4;
    int x = 10, y = 10;
    JLabel label1 = new JLabel(" text1 runs from left to right "), label2 = new JLabel("text2 runs in good way here  ");//, label3 = new JLabel("text3"), label4 = new JLabel("text4");
    RotatedLabel label3 = new RotatedLabel("text3 runs in a bad way("), label4  = new RotatedLabel("t4 runs UP-Down all the time  ");
    public void run()
    {
        while(true)
        {
            try
            {
                thread1.sleep(1);
                thread2.sleep(1);
                thread3.sleep(1);
                thread4.sleep(1);
            }
            catch (InterruptedException e) {
              }     
        }
    }
    public void init () {
        setSize(400, 200);
        setLayout(null);
        label1.setBounds(new Rectangle(new Point(1, 1), label1.getPreferredSize()));
        label2.setBounds(new Rectangle(new Point(1, 1), label2.getPreferredSize()));
        label3.setBounds(new Rectangle(new Point(1, 1), label3.getPreferredSize()));
        label4.setDirection(RotatedLabel.Direction.VERTICAL_UP);
        label4.setBounds(new Rectangle(new Point(1, 1), label4.getPreferredSize()));
        label3.setDirection(RotatedLabel.Direction.VERTICAL_DOWN);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        thread1 = new Thread(new Runnable() {
            public void run() {
                while(true)
                {
                    try
                    {
                        label1.setLocation(100, 180);
                        String text = label1.getText();
                        String text2 = text.substring(1)+  text.substring(0,1);
                        label1.setText(text2);
                        thread1.sleep(500);
                    }
                    catch (InterruptedException e) {
                      } 
                }
            }
       });
        thread2 = new Thread(new Runnable() {
            public void run() {
                while(true)
                {
                    try
                    {
                        label2.setLocation(100, 20);
                        String text = label2.getText();
                        String text2 = text.substring(text.length()-1)+  text.substring(0,text.length()-1);
                        label2.setText(text2);
                        thread2.sleep(500);
                    }
                    catch (InterruptedException e) {
                      } 
                }
            }
       });
        thread3 = new Thread(new Runnable() {
            public void run() {
                while(true)
                {
                    try
                    {
                        label3.setLocation(80, 28);
                        String text = label1.getText();
                        String text2 = text.substring(1)+  text.substring(0,1);
                        label3.setText(text2);
                        label3.setSize(10, 180);
                        thread3.sleep(500);
                    }
                    catch (InterruptedException e) {
                      } 
                }
            }
       });
        thread4 = new Thread(new Runnable() {
            public void run() {
                while(true)
                {
                    try
                    {
                        label4.setLocation(268, 25);
                        String text = label4.getText();
                        String text2 = text.substring(1)+  text.substring(0,1);
                        label4.setText(text2);


                        thread4.sleep(500);
                    }
                    catch (InterruptedException e) {
                      } 
                }
            }
       });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        }
}