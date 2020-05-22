import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Rough4 extends JFrame {
    Popup pop;
    JTextField mainTxt;
    List<String> options;
    DefaultListModel model;
    JList l;
    String[] myDataBase = { "Alice", "Bob", "Rose", "Coggu", "Alpha", "david","peter", "max" };


    Rough4() {
        options = Arrays.asList(myDataBase);

        mainTxt = new JTextField();
        mainTxt.setPreferredSize(new Dimension(100,20));
        mainTxt.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                char newChar = e.getKeyChar();
                if (isAsciiPrintable(newChar)) {
                    csearch(mainTxt.getText()+newChar);
                }
                else {
                    csearch(mainTxt.getText());
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


        JPanel panel = new JPanel();
        panel.add(mainTxt);


        this.add(panel);
        this.setPreferredSize(new Dimension(500,500));


        PopupFactory factory= PopupFactory.getSharedInstance();
        int x=200;
        int y=30;

        model = new DefaultListModel();
        l = new JList(model);
        l.setOpaque(true);
        l.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e)
            {
                if(l.getSelectedIndex()!=-1)
                {
                    mainTxt.setText((String)l.getSelectedValue());
                }
            }
        });
        pop = factory.getPopup(mainTxt,l,x+5,y+30);


        this.pack();
        this.setVisible(true);
    }

    public boolean isAsciiPrintable(char ch) {
        return ch >= 32 && ch < 127;
    }

    public void csearch(String letter) {
        model.removeAllElements();
        for (String option: options) {
            if (option.toLowerCase().startsWith(letter.toLowerCase())) {
                model.addElement(option);
            }
        }

        l.setModel(model);

        pop.show();
    }

    public final static void main(String[] args) {
        Rough4 r = new Rough4();
    }
}