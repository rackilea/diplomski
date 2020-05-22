import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ConvertGUI extends JFrame
{

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    JLabel cent = new JLabel();
    JLabel inch = new JLabel();

    private JTextField inches;
    private JTextField centimeters;

    private JButton INtoCMButton;
    private JButton CMtoINButton;

    public ConvertGUI()
    {

        super( "Measurement Converter Application" );
        setLayout( new FlowLayout() );

        ImageIcon icon=new ImageIcon( getClass().getResource("ruler.png"));

        label1 = new JLabel(icon);
        add( label1 );

        label2 = new JLabel( "metric converter" );
        add( label2 );

        label3 = new JLabel( "inches:" );
        add( label3 );

        label4 = new JLabel( "centimeters:" );
        add( label4 );

        centimeters = new JTextField( 10 );
        add( centimeters);

        inches = new JTextField( 10 );
        add( inches);

        INtoCMButton = new JButton( "Convert to CM" );
        INtoCMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                double num = Double.parseDouble( inches.getText() );
                double centimeters = (num *2.54);
                String INtoCM_String = String.format("%.1f", centimeters) ;
                cent.setText(INtoCM_String);
            }
        });

        add( INtoCMButton );
        CMtoINButton = new JButton( "Convert to IN" );
        CMtoINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                double num = Double.parseDouble( centimeters.getText() );
                double inch = (num /2.54);
                String CMtoIN_String= String.format("%.1f", inch) ;
                inches.setText( CMtoIN_String  );
            }
        });
        add( CMtoINButton );
    }
}