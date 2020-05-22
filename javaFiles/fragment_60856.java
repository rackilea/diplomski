import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private PanelTable2 table;
    private JScrollPane scrollPane;

    public GUI(){
        super("Bank Table");
        JPanel contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1000,700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final String[] columns = { "Big Column", "Serodys", "Ramírez", "Entrada", "MercaSur" };


        final String[][] data = {{"2323", "Hundreds","2323", "Hundreds","2323"},{"2323", "Hundreds","2323", "Hundreds","2323"}}; 
        // final PanelTable22 panel = new PanelTable22(data, columns);

        System.out.println("Hey");
        PanelTable2 table = new PanelTable2(data,columns);
        System.out.println("!!!");

        scrollPane = new JScrollPane(table);
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);

        add(scrollPane,BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String args[]){
        GUI gui =new GUI();
    }


}