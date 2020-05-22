import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.SwingPropertyChangeSupport;

public class MvcMain {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            MvcView view = new MvcView();
            MvcModel model = new MvcModel();
            MvcControl control = new MvcControl(view, model);
            view.createAndDisplay();
         }
      });
   }
}

class MvcView {
   private MvcModel model;
   private ButtonPanel buttonPanel = new ButtonPanel();
   private TextFieldPanel textFieldPanel = new TextFieldPanel();
   private JPanel mainPanel = new JPanel();

   public MvcModel getModel() {
      return model;
   }

   public ButtonPanel getButtonPanel() {
      return buttonPanel;
   }

   public TextFieldPanel getTextFieldPanel() {
      return textFieldPanel;
   }

   public MvcView() {
      mainPanel.setLayout(new GridLayout(0, 1));
      mainPanel.add(textFieldPanel);
      mainPanel.add(buttonPanel);
   }

   public void setModel(MvcModel model) {
      this.model = model;
      model.addPropertyChangeListener(new ModelListener());
   }

   public void createAndDisplay() {
      JFrame frame = new JFrame("MVC Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   private class ModelListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (ButtonTitle.class.getCanonicalName().equals(evt.getPropertyName())) {
            ButtonTitle newValue = model.getButtonTitle();
            textFieldPanel.textFieldSetText(newValue.getTitle());
         }
      }
   }
}

enum ButtonTitle {
   START("Start"), STOP("Stop"), PAUSE("Pause");
   private String title;

   private ButtonTitle(String title) {
      this.title = title;
   }

   public String getTitle() {
      return title;
   }
}

@SuppressWarnings("serial")
class ButtonPanel extends JPanel {
   public ButtonPanel() {
      setBorder(BorderFactory.createTitledBorder("Button Panel"));
      setLayout(new GridLayout(1, 0, 5, 0));
      for (ButtonTitle btnTitle : ButtonTitle.values()) {
         add(new JButton(new ButtonAction(btnTitle)));
      }
   }

   private class ButtonAction extends AbstractAction {
      private ButtonTitle btnTitle;

      public ButtonAction(ButtonTitle btnTitle) {
         super(btnTitle.getTitle());
         this.btnTitle = btnTitle;
      }

      public void actionPerformed(java.awt.event.ActionEvent e) {
         Object oldValue = null;
         ButtonTitle newValue = btnTitle;
         ButtonPanel.this.firePropertyChange(
               ButtonTitle.class.getCanonicalName(), oldValue, newValue);
      };
   }
}

@SuppressWarnings("serial")
class TextFieldPanel extends JPanel {
   private JTextField textField = new JTextField(15);

   public TextFieldPanel() {
      setBorder(BorderFactory.createTitledBorder("TextField Panel"));
      add(textField);
   }

   public void textFieldSetText(String text) {
      textField.setText(text);
   }
}

class MvcControl {
   private MvcView view;
   private MvcModel model;

   public MvcControl(MvcView view, MvcModel model) {
      this.view = view;
      this.model = model;
      view.setModel(model);
      view.getButtonPanel().addPropertyChangeListener(new ButtonPanelListener());
   }

   private class ButtonPanelListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (ButtonTitle.class.getCanonicalName().equals(evt.getPropertyName())) {
            ButtonTitle newValue = (ButtonTitle) evt.getNewValue();
            model.setButtonTitle(newValue);
         }
      }
   }
}

class MvcModel {
   private ButtonTitle buttonTitle;
   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(
         this);

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public ButtonTitle getButtonTitle() {
      return buttonTitle;
   }

   public void setButtonTitle(ButtonTitle buttonTitle) {
      ButtonTitle oldValue = this.buttonTitle;
      ButtonTitle newValue = buttonTitle;
      this.buttonTitle = buttonTitle;
      pcSupport.firePropertyChange(ButtonTitle.class.getCanonicalName(),
            oldValue, newValue);
   }
}