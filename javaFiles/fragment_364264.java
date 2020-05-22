package com.denisk.fun.swing;

import java.awt.*;
import javax.swing.*;

/**
 * Date: Mar 6, 2011
 * Time: 9:11:03 AM
 *
 * @author denisk
 */
public class GridBagLayoutTest extends JFrame {
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        frame.setContentPane(createContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static Container createContentPane() {
        int WINHEIGHT = 600;
        int WINWIDTH = 800;
        JPanel totalGui = new JPanel(); //this is the JPanel that will be returned
        totalGui.setBackground(Color.white);
        totalGui.setMinimumSize(new Dimension(WINWIDTH, WINHEIGHT));
        totalGui.setPreferredSize(new Dimension(WINWIDTH, WINHEIGHT));
        totalGui.setMaximumSize(new Dimension(WINWIDTH, WINHEIGHT));
        totalGui.setLayout(new GridBagLayout());
        totalGui.setOpaque(true);
        GridBagConstraints c = new GridBagConstraints();

        /* totalGui (the top-level JPane) has two JPanes called
               leftPanel and rightPanel. The widths of leftPanel and rightPanel
               are in the ratio 2:1. So, leftPanel takes up 2/3rd of the totalGui's
               width, and rightPanel gets the remaining 1/3rd */

        /* Top-level left panel */
        JPanel leftPanel = new JPanel();
        int LEFTPANELWIDTH = WINWIDTH * 2 / 3;
        leftPanel.setMinimumSize(new Dimension(LEFTPANELWIDTH, WINHEIGHT));
        leftPanel.setPreferredSize(new Dimension(LEFTPANELWIDTH, WINHEIGHT));
        leftPanel.setMaximumSize(new Dimension(LEFTPANELWIDTH, WINHEIGHT));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 4; //both leftPanel and rightPanel are 4 cells high
        c.gridwidth = 2; //leftPanel is 2 cells wide, rightPanel is 1 cell wide (code below)
        c.fill = GridBagConstraints.HORIZONTAL;
        totalGui.add(leftPanel, c);

        /* Vertical separator between leftPanel and rightPanel */
        c.gridx = 2; //'2' because leftPanel is 2 cells wide and the separator's leading
        //edge must lie in the third cell (gridx = 2) if it is to be
        //sandwiched between leftPanel and rightPanel
        c.gridy = 0;
        c.gridwidth = 0; //I've also tried gridwidth=1, but it doesn't solve the problem
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        JSeparator verticalsep = new JSeparator(SwingConstants.VERTICAL);
        verticalsep.setBackground(new Color(255, 0, 102));
        verticalsep.setPreferredSize(new Dimension(6, WINHEIGHT - 10)); //the 'WINHEIGHT-10' bit is purely cosmetic
        //I just wanted some space between the
        //separator edges and the window border
        //(also why the anchor is set to CENTER)
        totalGui.add(verticalsep, c); //PROBLEM: verticalsep is not displayed where I expected it to be;
        //please see attached image in post

        /* Top-level right panel */
        JPanel rightPanel = new JPanel();
        int RIGHTPANELWIDTH = WINWIDTH * 1 / 3;
        rightPanel.setBackground(Color.blue);
        rightPanel.setMinimumSize(new Dimension(RIGHTPANELWIDTH, WINHEIGHT));
        rightPanel.setPreferredSize(new Dimension(RIGHTPANELWIDTH, WINHEIGHT));
        rightPanel.setMaximumSize(new Dimension(RIGHTPANELWIDTH, WINHEIGHT));
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1; //rightPanel is 1 cell wide, leftPanel is 2 cells wide (code above)
        c.gridheight = 4; //both leftPanel and rightPanel are 4 cells high
        c.fill = GridBagConstraints.HORIZONTAL;
        totalGui.add(rightPanel, c);

        return totalGui;
    }
}