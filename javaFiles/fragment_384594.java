import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TableTest extends JFrame implements ActionListener{

    JTable table ;
    JButton button;
    public TableTest(){
        String []colNames = {"Subject","lecturer"}; 
        String [][] rowDatas = { {"Java Programming","Jon"},
                                 {"C++ Programming","Nuhara"},
                                 {"Mathematicz","Mike"},
                                 {"Database","Saran"}
                                };
        table = new JTable(rowDatas,colNames);

        button = new JButton("Show Last Record");
        button.addActionListener(this);

        this.add(table);
        this.add(button);
        this.setVisible(true);
        this.setSize(300,200);
        this.setDefaultCloseOperation(3);
        this.setLayout(new FlowLayout());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int i= table.getRowCount()-1;
        int j= table.getColumnCount();
        Object [] value = new Object[j];
        for(int k = 0 ; k<j ; k++)
        {
        //value[k] = table.getValueAt(i,k);
            System.out.println(table.getValueAt(i, k));
        }  
    }


    public static void main(String...ag){
        new TableTest();
    }
}