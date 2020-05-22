import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.border.*;
import java.util.Random;
import java.applet.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JFrame {

    JButton button1, button2, button3, button4, button5;
    JLabel label1, label2, label3;
    JPanel panel1, panel2;

    File wavFile1 = new File("NewRing1.wav");
    File wavFile2 = new File("NewRing2.wav");
    File wavFile3 = new File("NewRing3.wav");
    File wavFile4 = new File("NewRing4.wav");
    AudioClip sound1;
    AudioClip sound2;
    AudioClip sound3;
    AudioClip sound4;

    int level;
    int score;
    int[] anArray;
    int currentArrayPosition;

    public Game() {
        GridLayout grid = new GridLayout(3, 2);
        this.getContentPane().setLayout(grid);
        Container theContainer = this.getContentPane();
        EtchedBorder edge = new EtchedBorder(EtchedBorder.RAISED);

        level = 0;
        score = 0;
        button1 = new JButton();
        button1.setForeground(Color.BLACK);
        button1.setBackground(Color.RED);

        button2 = new JButton();
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.BLUE);

        button3 = new JButton();
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.GREEN);

        button4 = new JButton();
        button4.setForeground(Color.BLACK);
        button4.setBackground(Color.YELLOW);

        button5 = new JButton("Begin");

        label1 = new JLabel("Score: " + String.valueOf(score));
        label2 = new JLabel("High Score");
        label3 = new JLabel("Follow The Pattern");

        panel1 = new JPanel();
        panel1.add(label1);
        panel1.add(label2);

        panel2 = new JPanel();
        panel2.add(label3);
        panel2.add(button5);

        button1.setBorder(edge);
        button2.setBorder(edge);
        button3.setBorder(edge);
        button4.setBorder(edge);
        label1.setBorder(edge);
        label2.setBorder(edge);
        panel1.setBorder(edge);
        panel2.setBorder(edge);
        label3.setBorder(edge);

        theContainer.add(panel1);
        theContainer.add(panel2);
        theContainer.add(button1);
        theContainer.add(button2);
        theContainer.add(button3);
        theContainer.add(button4);

        Button1Handler handleButton1 = new Button1Handler();
        button1.addActionListener(handleButton1);

        Button2Handler handleButton2 = new Button2Handler();
        button2.addActionListener(handleButton2);

        Button3Handler handleButton3 = new Button3Handler();
        button3.addActionListener(handleButton3);

        Button4Handler handleButton4 = new Button4Handler();
        button4.addActionListener(handleButton4);

        Button5Handler handleButton5 = new Button5Handler();
        button5.addActionListener(handleButton5);

        try {
            sound1 = Applet.newAudioClip(wavFile1.toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sound2 = Applet.newAudioClip(wavFile2.toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sound3 = Applet.newAudioClip(wavFile3.toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sound4 = Applet.newAudioClip(wavFile4.toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public class Button1Handler implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            sound1.play();
            buttonClicked(button1);
        }
    }

    public class Button2Handler implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            sound2.play();
            buttonClicked(button2);
        }
    }

    public class Button3Handler implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            sound3.play();
            buttonClicked(button3);
        }
    }

    public class Button4Handler implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            sound4.play();
            buttonClicked(button4);
        }
    }

    private void buttonClicked(JButton clickedButton) {
        if (isCorrectButtonClicked(clickedButton)) {
            currentArrayPosition++;
            addToScore(1);
            if (currentArrayPosition == anArray.length) {
                playNextSequence();
            } else {
            }
        } else {
            JOptionPane.showMessageDialog(this, String.format("Your scored %s points", score));
            score = 0;
            level = 0;
            label1.setText("Score: " + String.valueOf(score));
        }
    }

    private boolean isCorrectButtonClicked(JButton clickedButton) {
        int correctValue = anArray[currentArrayPosition];
        if (clickedButton.equals(button1)) {
            return correctValue == 1;
        } else if (clickedButton.equals(button2)) {
            return correctValue == 2;
        } else if (clickedButton.equals(button3)) {
            return correctValue == 3;
        } else if (clickedButton.equals(button4)) {
            return correctValue == 4;
        } else {
            return false;
        }
    }

    public class Button5Handler implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            playNextSequence();
        }
    }

    private void playNextSequence() {
        level++;
        currentArrayPosition = 0;
        anArray = createSequence(level);
        (new Thread(new SequenceButtonClicker())).start();
    }

    private int[] createSequence(int sequenceLength) {
        int[] sequence = new int[sequenceLength];
        for (int i = 0; i < sequenceLength; i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt(40) % 4 + 1;
            sequence[i] = randomNum;
        }
        return sequence;
    }

    private JButton getButtonFromInt(int sequenceNumber) {
        switch (sequenceNumber) {
            case 1:
                return button1;
            case 2:
                return button2;
            case 3:
                return button3;
            case 4:
                return button4;
            default:
                return button1;
        }
    }

    private void flashButton(JButton button) throws InterruptedException {
        Color originalColor = button.getBackground();
        button.setBackground(new Color(255, 255, 255, 200));
        Thread.sleep(250);
        button.setBackground(originalColor);
    }

    private void soundButton(JButton button) {
        if (button.equals(button1)) {
            sound1.play();
        } else if (button.equals(button2)) {
            sound2.play();
        } else if (button.equals(button3)) {
            sound3.play();
        } else if (button.equals(button4)) {
            sound4.play();
        }
    }

    private void addToScore(int newPoints) {
        score += newPoints;
        label1.setText("Score: " + String.valueOf(score));
    }

    private class SequenceButtonClicker implements Runnable {

        public void run() {
            for (int i = 0; i < anArray.length; i++) {
                try {
                    JButton nextButton = getButtonFromInt(anArray[i]);
                    soundButton(nextButton);
                    flashButton(nextButton);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, "Interrupted", ex);
                }
            }
        }
    }
}