import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBoxTestLength  {

    JComboBoxTestLength (){
        JFrame f=new JFrame("ComboBox Example");
        String country[]={"Long Item 5","Long Item 2","Long Item 1","Long Item 8","Long Item 4"};
        JComboBox<String> cb=new JComboBox<>(country);
        JPanel comboPane = new JPanel(); //uses FlowLayout by default
        comboPane.add(cb);
        f.add(cb); //JFrame content pane uses BorderLayout by default 
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new JComboBoxTestLength ();
    }
}