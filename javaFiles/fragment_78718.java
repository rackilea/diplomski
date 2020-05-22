import javax.swing.*;
import java.awt.Font;
import java.awt.FlowLayout;

class JLabelLocation  {

    public static void main( String [] args ) {

        JLabel mainTitle = new JLabel("SomeApp");
        mainTitle.setFont(new Font("Arial",2 , 28));
        //mainTitle.setBounds(0,0, 115, 130); //let the layout do the work

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));// places at the left
        panel.add( mainTitle );

        frame.add( panel );// no need to call getContentPane
        frame.pack();
        frame.setVisible( true );

    }
}