import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ButtonInPane extends JFrame implements KeyListener {
  // input
  String input;
  //context
  JLabel context1, context2;
  // default color
  Color defaultColor = new JButton().getBackground();
  // main rows of keys
  public String rowOne[] = {
      "~",
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "0",
      "-",
      "+",
      "h"
  };
  public String rowTwo[] = {
      "Tab",
      "Q",
      "W",
      "E",
      "R",
      "T",
      "Y",
      "U",
      "I",
      "O",
      "P",
      "[",
      "]",
      "\\"
  };
  public String rowThree[] = {
      "Caps",
      "A",
      "S",
      "D",
      "F",
      "G",
      "H",
      "J",
      "K",
      "L",
      ":",
      "'",
      "Enter"
  };
  public String rowFour[] = {
      "Shift",
      "Z",
      "X",
      "C",
      "V",
      "B",
      "N",
      "M",
      ",",
      ".",
      "?",
      "   ^"
  };
  public String rowFive[] = {
      "       ",
      "<",
      "v",
      ">"
  };
  /**
   * Account for chars with no shift: Program toggles Shift key, meaning if a
   * user clicks on it, all keys will be toggled to their respective shift
   * value. The user can tap the shift key again to change back to regular
   * value
   */
  public String shiftless[] = {
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9",
      "0",
      "-",
      "=",
      "q",
      "w",
      "e",
      "r",
      "t",
      "y",
      "u",
      "i",
      "o",
      "p",
      "[",
      "]",
      "\\",
      "a",
      "s",
      "d",
      "f",
      "g",
      "h",
      "j",
      "k",
      "l",
      ";",
      "z",
      "x",
      "c",
      "v",
      "b",
      "n",
      "m",
      ",",
      ".",
      "/"
  };
  // Account for special chars
  public String specialChars[] = {
      "~",
      "-",
      "+",
      "[",
      "]",
      "\\",
      ";",
      ".",
      "?"
  };

  // declare rows of buttons
  public JButton buttons_rowOne[], buttons_rowTwo[], buttons_rowThree[], buttons_rowFour[], buttons_rowFive[];
  private JTextArea body;
  private JPanel top;
  private JPanel middle;
  private JPanel bottom;
  private JPanel contextBox;

  // ctor
  public ButtonInPane() {
      super("Typing Tutor");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setResizable(false);
      this.getContentPane().setPreferredSize(new Dimension(2000, 600));
      this.setLocation(50, 50);
      this.setVisible(true);
      __init__();
  }

  public void __init__layout(JPanel top, JPanel middle, JPanel bottom, JPanel contextBox) {
      setLayout(new BorderLayout());
      add(top, BorderLayout.NORTH);
      add(contextBox);
      add(middle, BorderLayout.CENTER);
      add(bottom, BorderLayout.SOUTH);
  }

  public void __init__body() {
      body = new JTextArea();
      body.setPreferredSize(new Dimension(600, 150));
      body.addKeyListener(this);
  }

  public void __init__panels() {
      context1 = new JLabel("Type some text using your keyboard. " +
          "The keys you press will be highlighed and the text will be displayed.");
      context2 = new JLabel("\nNote: Clicking the buttons with your mouse will not perform any action.");
      context1.setFont(new Font("Verdana", Font.BOLD, 14));
      context2.setFont(new Font("Verdana", Font.BOLD, 14));
      top = new JPanel();
      top.setSize(new Dimension(500, 500));
      middle = new JPanel();
      bottom = new JPanel();
      contextBox = new JPanel();
      __init__layout(top, middle, bottom, contextBox);
      top.setLayout(new BorderLayout());
      bottom.setLayout(new GridLayout(5, 1));
      top.add(context2);
      top.add(context1);
      middle.setLayout(new BorderLayout());
      middle.add(body, BorderLayout.WEST);
      middle.add(body, BorderLayout.CENTER);
  }

  public void __init__() {
      // text area
      __init__body();
      // panels for layout
      __init__panels();
      pack();
      // get length of row strings
      int length_rowOne = rowOne.length;
      int length_rowTwo = rowTwo.length;
      int length_rowThree = rowThree.length;
      int length_rowFour = rowFour.length;
      int length_rowFive = rowFive.length;
      // create array for each row of buttons
      buttons_rowOne = new JButton[length_rowOne];
      buttons_rowTwo = new JButton[length_rowTwo];
      buttons_rowThree = new JButton[length_rowThree];
      buttons_rowFour = new JButton[length_rowFour];
      buttons_rowFive = new JButton[length_rowFive];
      // create panel for each row of buttons
      JPanel r1 = new JPanel(new GridLayout(1, length_rowOne));
      JPanel r2 = new JPanel(new GridLayout(1, length_rowTwo));
      JPanel r3 = new JPanel(new GridLayout(1, length_rowThree));
      JPanel r4 = new JPanel(new GridLayout(1, length_rowFour));
      JPanel r5 = new JPanel(new GridLayout(1, length_rowFive));
      // draw out the rows of buttons
      draw(r1, length_rowOne, r2, length_rowTwo, r3, length_rowThree, r4, length_rowFour, r5, length_rowFive);

  }

  // draw rows of buttons
  public void draw(JPanel r1, int s1, JPanel r2, int s2, JPanel r3, int s3, JPanel r4, int s4, JPanel r5, int s5) {
      for (int i = 0; i < s1; i++) {
          JButton currentButton = new JButton(rowOne[i]);
          currentButton.setPreferredSize(new Dimension(100, 50));
          buttons_rowOne[i] = currentButton;
          r1.add(buttons_rowOne[i]);
      }
      for (int i = 0; i < s2; i++) {
          JButton currentButton = new JButton(rowTwo[i]);
          currentButton.setPreferredSize(new Dimension(100, 50));
          buttons_rowTwo[i] = currentButton;
          r2.add(buttons_rowTwo[i]);
      }
      for (int i = 0; i < s3; i++) {
          JButton currentButton = new JButton(rowThree[i]);
          currentButton.setPreferredSize(new Dimension(100, 50));
          buttons_rowThree[i] = currentButton;
          r3.add(buttons_rowThree[i]);
      }
      for (int i = 0; i < s4; i++) {
          JButton currentButton = new JButton(rowFour[i]);
          currentButton.setPreferredSize(new Dimension(100, 50));
          buttons_rowFour[i] = currentButton;
          r4.add(buttons_rowFour[i]);
      }
      for (int i = 0; i < s5; i++) {
          JButton currentButton = new JButton(rowFive[i]);
          // account for space bar
          if (i == 1) {
              currentButton = new JButton(rowFive[i]);
              currentButton.setPreferredSize(new Dimension(400, 10));
              currentButton.setBounds(10, 10, 600, 100);
              buttons_rowFive[i] = currentButton;
          } else {
              currentButton.setPreferredSize(new Dimension(100, 50));
              buttons_rowFive[i] = currentButton;
          }
          r5.add(buttons_rowFive[i]);
      }
      bottom.add(r1);
      bottom.add(r2);
      bottom.add(r3);
      bottom.add(r4);
      bottom.add(r5);
  } // !draw(...)
  // called when a button is pressed

  @Override
  public void keyPressed(KeyEvent press) {
      StringBuilder sb = new StringBuilder();
      sb.append(press.getKeyChar());
      body.append(sb.toString());
  } // !keyPressed(...)
  // called when a button is released

  @Override
  public void keyReleased(KeyEvent release) {
       Object current = release.getSource();
  } // !keyReleased(...)

  @Override
  public void keyTyped(KeyEvent typed) {
      Object current = typed.getSource();
  }

  // main method
  public static void main(String[] args) {
      new ButtonInPane();
  } // !main method

  private static final long serialVersionUID = 999;
} // !main class