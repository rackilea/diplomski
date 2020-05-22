import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class GetLetterTextGui extends JPanel {
   private static final int TA_ROWS = 20;
   private static final int TA_COLS = 35;
   private static final int PROVIDER_FIELD_COLS = 10;
   private static final String GUI_TITLE = "Get Letter Text";
   private JList letterList;
   private JTextArea textarea = new JTextArea(TA_ROWS, TA_COLS);
   private JTextField providerField = new JTextField(PROVIDER_FIELD_COLS);
   private JCheckBox addValedictionChkBox = new JCheckBox("Add Valediction", true);

   public GetLetterTextGui() {
      letterList = new JList(new String[]{"Fe", "Fi", "Fo", "Fum"});

      providerField.setText("John Smith, MD");

      textarea.setWrapStyleWord(true);
      textarea.setLineWrap(true);

      JPanel northPanel = new JPanel();
      northPanel.add(new JLabel("Provider:"));
      northPanel.add(providerField);

      JPanel southPanel = new JPanel();
      JPanel btnPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      btnPanel.add(new JButton("Copy to Clipboard"));
      btnPanel.add(new JButton("Clear"));
      btnPanel.add(new JButton(new ExitAction()));
      southPanel.add(btnPanel);

      JPanel eastPanel = new JPanel();
      eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
      eastPanel.add(new JScrollPane(letterList));
      eastPanel.add(new JPanel() {{add(addValedictionChkBox);}});

      int eb = 0;
      setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));
      setLayout(new BorderLayout(eb, eb));
      add(northPanel, BorderLayout.PAGE_START);
      add(eastPanel, BorderLayout.LINE_END);
      add(new JScrollPane(textarea), BorderLayout.CENTER);
      add(southPanel, BorderLayout.PAGE_END);
   }


   private class ExitAction extends AbstractAction {
      private final Object MNEMONIC = new Integer(KeyEvent.VK_X);

      public ExitAction() {
         super("Exit");
         putValue(MNEMONIC_KEY, MNEMONIC);
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         Window win = SwingUtilities.getWindowAncestor(GetLetterTextGui.this);
         win.dispose();
      }
   }

   private static void createAndShowGui() {
      GetLetterTextGui mainPanel = new GetLetterTextGui();

      JFrame frame = new JFrame(GUI_TITLE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      try {
         for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }

         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGui();
            }
         });

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (UnsupportedLookAndFeelException e) {
         e.printStackTrace();
      }
   }
}