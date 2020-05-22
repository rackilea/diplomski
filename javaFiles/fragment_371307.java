package com.learningjava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * a simple demo to using two dialog
 *
 */
public class DialogFrameDemo extends JFrame{
    public static void main(String[] args) {
        DialogFrameDemo frame = new DialogFrameDemo();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public DialogFrameDemo() {
        super("Dialog Demo");
        //prepare button in frame
        JButton btnInFrame = new JButton("Click to open a Dialog");
        JPanel framePanel = new JPanel();
        framePanel.add(btnInFrame);
        this.add(framePanel,BorderLayout.NORTH);

        btnInFrame.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // generate dialog one
                dialogOne = new JDialog(DialogFrameDemo.this,"Dialog one",false);
                JPanel dialogPanel = new JPanel();
                dialogPanel.setLayout(new GridLayout(3,1));
                //prepare button in dialog one
                JButton btnInDialogOne = new JButton("Click to open another Dialog");
                btnInDialogOne.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //generate dialog second
                        JDialog dialogTwo = new JDialog(dialogOne,"Dialog Two",true);
                        JPanel dialogPanel = new JPanel();
                        dialogPanel.setLayout(new GridLayout(3,1));
                        dialogPanel.add(new JLabel("Dialog Two"));
                        dialogPanel.add(new JLabel("Lable 21"));
                        dialogPanel.add(new JLabel("Lable 22"));
                        dialogTwo.setContentPane(dialogPanel);
                        dialogTwo.pack();
                        dialogTwo.setVisible(true);
                        dialogTwo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                });
                dialogPanel.add(btnInDialogOne);
                dialogPanel.add(new JLabel("Lable 11"));
                dialogPanel.add(new JLabel("Lable 12"));
                dialogOne.setContentPane(dialogPanel);
                dialogOne.pack();
                dialogOne.setVisible(true);
                dialogOne.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            }
        });
    }

    private static final long serialVersionUID = 1L;
    private JDialog dialogOne;
}