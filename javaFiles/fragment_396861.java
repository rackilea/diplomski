package javaapplication7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;  
public class JavaApplication7 extends JFrame {
    JCheckBox cookLite,extraSauce,lightSauce,wellDone,lightCheese;

    JavaApplication7(){  



        JLabel label1 = new JLabel();
        label1.setText("Cooking Instructions");

        setLayout(new BorderLayout());
        add(label1,BorderLayout.NORTH);

        cookLite = new JCheckBox("Cook Lite");
        extraSauce = new JCheckBox("Extra Sauce");
        lightSauce = new JCheckBox("Light Sauce");
        wellDone = new JCheckBox("Well Done");
        lightCheese = new JCheckBox("Light Cheese");

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,2));
        panel.add(cookLite);
        panel.add(extraSauce);
        panel.add(lightSauce);
        panel.add(wellDone);
        panel.add(lightCheese);

        add(panel,BorderLayout.CENTER);

        setSize(400,500); 
        setVisible(true);  

    }  
    public static void main(String[] args) {
        new JavaApplication7();  
    }

}