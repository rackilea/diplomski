import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class RecordViewer extends JDialog {

 String items[] = {"One", "Two", "Three"};
 JButton next, prev;
 JLabel label;
 int current;

public RecordViewer(){
    super();
    current = 0;
    label = new JLabel(items[current]);
    next = new JButton("Next");
    next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(current == items.length - 1){
                current = 0;
            }else{
                current++;
            }
            label.setText(items[current]);
        }
    });

    prev = new JButton("Previous");
    prev.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(current == 0){
                current = items.length - 1;
            }else{
                current--;
            }
            label.setText(items[current]);
        }
    });

    setLayout(new FlowLayout());
    add(label);
    add(next);
    add(prev);
    pack();
    this.setVisible(true);
  }
 }