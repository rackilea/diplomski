import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MVCTester {
   public static void main(String[] args) {
      MVCController myMVC = new MVCController();
      MVCViews myViews = new MVCViews(myMVC);
      myMVC.attach(myViews);  
      // myViews.setController(myMVC); // or this could do it
   }
}

class MVCController {
   MVCModel model;
   ArrayList<ChangeListener> listeners;

   public MVCController() {
      model = new MVCModel();
      listeners = new ArrayList<ChangeListener>();
   }

   public void update(String input) {
      model.setInputs(input);
      for (ChangeListener l : listeners) {
         l.stateChanged(new ChangeEvent(this));
      }
   }

   public void attach(ChangeListener c) {
      listeners.add(c);
   }
}

class MVCModel {
   private ArrayList<String> inputs;

   MVCModel() {
      inputs = new ArrayList<String>();
   }

   public ArrayList<String> getInputs() {
      return inputs;
   }

   public void setInputs(String input) {
      inputs.add(input);
   }
}

class MVCViews implements ChangeListener {
   private JTextField input;
   private JTextArea echo;
   private ArrayList<String> toPrint = new ArrayList<String>();
   MVCController controller;

   MVCViews(final MVCController controller) {
      // !! controller = new MVCController();
      this.controller = controller;
      JPanel myPanel = new JPanel();
      JButton addButton = new JButton("add");
      echo = new JTextArea(10, 20);
      echo.append("Hello there! \n");
      echo.append("Type something below!\n");
      myPanel.setLayout(new BorderLayout());
      myPanel.add(addButton, BorderLayout.NORTH);
      input = new JTextField();
      final JFrame frame = new JFrame();
      frame.add(myPanel, BorderLayout.NORTH);
      frame.add(echo, BorderLayout.CENTER);
      frame.add(input, BorderLayout.SOUTH);
      addButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (controller != null) {
               controller.update(input.getText());
            }
         }
      });
      frame.pack();
      frame.setVisible(true);
   }

   public void setController(MVCController controller) {
      this.controller = controller;
   }

   @Override
   public void stateChanged(ChangeEvent e) {
      if (controller != null) {
         toPrint = controller.model.getInputs();
         for (String s : toPrint) {
            echo.append(s + "\n");
         }
      }
   }
}