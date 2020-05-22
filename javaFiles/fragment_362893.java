import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.*;

        public class XO2 implements ActionListener {
        private int[][] winningCombination = new int[][] {
                {0, 1, 2},
                            {3, 4, 5},
                            {6, 7, 8}, 
                {0, 3, 6},
                            {1, 4, 7},
                            {2, 5, 8}, 
                {0, 4, 8},
                            {3, 4, 6}            
        };
        private JFrame window = new JFrame("Tic Tac Toe");
        private JButton buttons[] = new JButton[9];
        private int count = 0;
        private String letter = "";
        private boolean win = false;

        public XO2(){

            window.setSize(300,300);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setLayout(new GridLayout(3,3));


            for(int i=0; i<9; i++){
                buttons[i] = new JButton();
                window.add(buttons[i]);
                buttons[i].addActionListener(this);
            }


            window.setVisible(true);
        }


        public void actionPerformed(ActionEvent a) {
            count++;


            if(count % 2 == 0){
                letter = "O";
            }
            else {
                letter = "X";
            }


            JButton pressedButton = (JButton)a.getSource();
            pressedButton.setText(letter);
            pressedButton.setEnabled(false);


            for(int i=0; i<8; i++){
                if( buttons[winningCombination[i][0]].getText().equals(buttons[winningCombination[i][1]].getText()) &&
                        buttons[winningCombination[i][1]].getText().equals(buttons[winningCombination[i][2]].getText()) &&
                        !buttons[winningCombination[i][0]].getText().equals("")){
                    win = true;
                }
            }


            if(win == true){
                JOptionPane.showMessageDialog(null, letter + " Won!");
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( "c:\\calc\\output.txt", true)));
                    out.println(letter + "Won!");
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            } else if(count == 9 && win == false){
                JOptionPane.showMessageDialog(null, "Draw!");
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter( "c:\\calc\\output.txt", true)));
                    out.println("Draw!");
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.exit(0);
            }
        }

        public static void main(String[] args){
            XO2 starter = new XO2();
        }

}