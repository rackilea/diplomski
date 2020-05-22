import java.awt.*;
 import javax.swing.*;
 import javax.swing.BoxLayout;
 import java.awt.event.*;


public class JframeLink {




    public static void main(String[] args) 
    {
        new JframeOneGui();
        new JframeTwoGui();
    }


    //JFrame one Object
    public static class JframeOneGui extends JFrame implements ActionListener
    {
        JPanel jPanelOne = new JPanel();
        JTextField textField1 = new JTextField("Message for transfer");
        JButton buttonOne = new JButton("Transfer");

        public JframeOneGui()
        {
            //setup swing components
            textField1.setSize(100,10);
            buttonOne.addActionListener(this);
            //setup jPanelOne
            jPanelOne.setLayout(new BoxLayout(jPanelOne, 1));
            jPanelOne.add(textField1);
            jPanelOne.add(buttonOne);
            //setup JframeOneGui
            this.add("Center",jPanelOne);
            this.setLocation(25,25);
            this.setTitle("JframeOneGui");
            this.setSize(200,200);
            this.setResizable(false);
            this.setVisible(true);
        }


        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == buttonOne)
            {
                //Here we are calling JframeTwoGui's Setter method
                JframeTwoGui.setTextFieldOne(textField1.getText());
            }
        }   

    }

    //JFrame two Object
    public static class JframeTwoGui extends JFrame
    {
        JPanel jPanelOne = new JPanel();
        static JTextField textField1 = new JTextField();

        public JframeTwoGui()
        {


            jPanelOne.setLayout(new BoxLayout(jPanelOne, 1));
            jPanelOne.add(textField1);

            this.add("Center",jPanelOne);
            this.setLocation(300,25);
            this.setTitle("JframeTwoGui");
            this.setSize(200,200);
            this.setResizable(false);
            this.setVisible(true);

        }

        //Setter to change TextFieldOne in this Object
        public static void setTextFieldOne(String text)
        {
            textField1.setText(text);

        }
    }




}