import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

@SuppressWarnings("serial")
public class View {
   enum TextAreaDestination {
      EGD_IMPRESSION("EGD Impression"),
      EGD_RECOMMENDATIONS("EGD Recommendations"),
      COLON_IMPRESSION("Colon Impression"),
      COLON_RECOMMENDATIONS("Colon Recommendations"),
      ERROR_MESSAGES("Error Messages");

      private String text;
      private TextAreaDestination(String text) {
         this.text = text;
      }

      public String getText() {
         return text;
      }

      @Override
      public String toString() {
         return text;
      }
   }

   public enum GuiButtonText {
      GET_ONE_PROC("Get One Proc", KeyEvent.VK_O),
      GET_TWO_PROCs("Get Two Procs", KeyEvent.VK_T), 
      INTO_FLOW("Into Flow", KeyEvent.VK_F),
      CLEAR_ALL("Clear All", KeyEvent.VK_C),
      F_U_PROC_FLAG("F/U Proc Flag", KeyEvent.VK_U),
      SIGN_NEXT("Sign/Next", KeyEvent.VK_S),
      EXIT("Exit", KeyEvent.VK_X);
      private String text;
      private int mnemonic;
      private GuiButtonText(String text, int mnemonic) {
         this.text = text;
         this.mnemonic = mnemonic;
      }
      public String getText() {
         return text;
      }
      public int getMnemonic() {
         return mnemonic;
      }
   }

   public static final String BUTTON_PRESSED = "Button Pressed";

   private static final int TA_ROWS = 4;
   private static final int TA_COLS = 50;
   private JPanel mainPanel = new JPanel();
   private SwingPropertyChangeSupport spcSupport = new SwingPropertyChangeSupport(
         this);
   private Map<TextAreaDestination, JTextArea> impressionRecMap = new HashMap<TextAreaDestination, JTextArea>();

   public View() {
      JPanel textAreasPanel = createTextAreasPanel();
      JPanel buttonsPanel = createButtonsPanel();

      mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      mainPanel.setLayout(new BorderLayout(5, 5));
      mainPanel.add(textAreasPanel, BorderLayout.CENTER);
      mainPanel.add(buttonsPanel, BorderLayout.PAGE_END);
   }

   private JPanel createButtonsPanel() {
      JPanel buttonsPanel = new JPanel(new GridLayout(2, 0, 5, 5));
      for (final GuiButtonText guiBtnText : GuiButtonText.values()) {
         AbstractAction btnAction = new AbstractAction(guiBtnText.getText()) {
            {putValue(MNEMONIC_KEY, guiBtnText.getMnemonic()); }
            @Override
            public void actionPerformed(ActionEvent e) {
               spcSupport.firePropertyChange(BUTTON_PRESSED, null, guiBtnText);               
            }
         };
         JButton button = new JButton(btnAction);
         buttonsPanel.add(button);
      }
      return buttonsPanel;
   }

   private JPanel createTextAreasPanel() {
      JPanel textAreasPanel = new JPanel();
      textAreasPanel.setLayout(new BoxLayout(textAreasPanel,
            BoxLayout.PAGE_AXIS));
      for (TextAreaDestination textDest : TextAreaDestination.values()) {
         JTextArea tArea = new JTextArea(TA_ROWS, TA_COLS);
         tArea.setName(textDest.getText());
         tArea.setWrapStyleWord(true);
         tArea.setLineWrap(true);
         impressionRecMap.put(textDest, tArea);
         JScrollPane scrollPane = new JScrollPane(tArea);
         JPanel outerPanel = new JPanel(new BorderLayout());
         outerPanel.setBorder(BorderFactory.createTitledBorder(textDest.getText()));
         outerPanel.add(scrollPane);
         textAreasPanel.add(outerPanel);
      }
      return textAreasPanel;
   }

   public String textAreasGetText(TextAreaDestination key) {
      JTextArea textArea = impressionRecMap.get(key);
      if (textArea != null) {
         return textArea.getText();
      } else {
         return ""; // throw exception
      }
   }

   public void textAreasSetText(TextAreaDestination key, String text) {
      JTextArea textArea = impressionRecMap.get(key);
      if (textArea != null) {
         textArea.setText(text);
      } else {
         // throw exception?
      }
   }

   public void textAreaAppend(TextAreaDestination key, String text) {
      JTextArea textArea = impressionRecMap.get(key);
      textArea.append(text);
   }

   public void clearAllAreas() {
      for (TextAreaDestination taDest : TextAreaDestination.values()) {
         textAreasSetText(taDest, "");
      }
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      spcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      spcSupport.removePropertyChangeListener(listener);
   }

   public JPanel getMainPanel() {
      return mainPanel;
   }

   public static void main(String[] args) {
      Control.main(args);
   }
}