package com.zetcode;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class GoodLayout2 extends JFrame {

    private JPanel pnl;

    public GoodLayout2() {

        initUI();

        setTitle("MigLayout solution");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUI() {

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new AddAction());

        pnl = new JPanel(new MigLayout("ins dialog, wrap 2"));
        pnl.add(addBtn, "span 2, center");
        pnl.add(new JTextField(10));
        pnl.add(new JTextField(10), "pushx, growx");
        pnl.add(new JTextField(10));
        pnl.add(new JTextField(10), "pushx, growx");
        pnl.add(new JTextField(10));
        pnl.add(new JTextField(10), "pushx, growx");

        add(pnl);
        pack();

    }

    private class AddAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            pnl.add(new JTextField(10));
            pnl.add(new JTextField(10), "pushx, growx");
            pnl.doLayout();
            pnl.repaint();
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GoodLayout2 ex = new GoodLayout2();
                ex.setVisible(true);
            }
        });
    }
}