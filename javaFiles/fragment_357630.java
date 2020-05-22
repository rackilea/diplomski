package pkg2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MainGui extends JPanel {
    private static final String[] CMD_TEXT = {"java", "-cp"}; 
    private static final String TEST_PROGRAM = "pkg2.TestProgram";
    private JTextArea inputTextArea = new JTextArea(15, 30);
    private JTextArea errorTextArea = new JTextArea(15, 30);
    private List<String> commands = new ArrayList<>();

    public MainGui() {
        for (String cmd : CMD_TEXT) {
            commands.add(cmd);
        }
        String classpath = System.getProperty("java.class.path");
        commands.add(classpath);
        commands.add(TEST_PROGRAM);

        inputTextArea.setFocusable(false);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Border outsideBorder = BorderFactory.createTitledBorder("Input Messages");
        Border border = BorderFactory.createCompoundBorder(outsideBorder, inputScrollPane.getBorder());
        inputScrollPane.setBorder(border);

        errorTextArea.setFocusable(false);
        JScrollPane errorScrollPane = new JScrollPane(errorTextArea);
        errorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outsideBorder = BorderFactory.createTitledBorder("Error Messages");
        border = BorderFactory.createCompoundBorder(outsideBorder, errorScrollPane.getBorder());
        errorScrollPane.setBorder(border);

        JPanel twoAreasPanel = new JPanel(new GridLayout(1, 0, 3, 3));
        twoAreasPanel.add(inputScrollPane);
        twoAreasPanel.add(errorScrollPane);

        JPanel btnPanel = new JPanel(new GridLayout(1, 0, 3, 3));
        btnPanel.add(new JButton(new LaunchProcessAction()));
        btnPanel.add(new JButton(new ExitAction()));

        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        setLayout(new BorderLayout(3, 3));
        add(twoAreasPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);        
    }

    private class SwWrapperListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                SwingWorkerWrapper swW = (SwingWorkerWrapper) evt.getSource();
                try {
                    int exitCode = swW.get();
                    inputTextArea.append("Exit Code: " + exitCode + "\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    inputTextArea.append(e.getLocalizedMessage());
                    inputTextArea.append("\n");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    inputTextArea.append(e.getLocalizedMessage());
                    inputTextArea.append("\n");
                }
            } else if (GobblerType.OUTPUT.toString().equals(evt.getPropertyName())) {
                inputTextArea.append(evt.getNewValue() + "\n");
            } else if (GobblerType.ERROR.toString().equals(evt.getPropertyName())) {
                errorTextArea.append(evt.getNewValue() + "\n");
            }

        }
    }

    private class LaunchProcessAction extends MyAction {
        public LaunchProcessAction() {
            super("Launch Process", KeyEvent.VK_L);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingWorkerWrapper swWrapper = new SwingWorkerWrapper(commands);
            swWrapper.addPropertyChangeListener(new SwWrapperListener());
            swWrapper.execute();
        }
    }

    private class ExitAction extends MyAction {
        public ExitAction() {
            super("Exit", KeyEvent.VK_X);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private static abstract class MyAction extends AbstractAction {
        public MyAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
    }

    private static void createAndShowGui() {
        MainGui mainPanel = new MainGui();

        JFrame frame = new JFrame("Main GUI");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}