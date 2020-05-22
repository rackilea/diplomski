import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class WaitForGUI
{
    public static void main(String[] args)
    {
        WaitForGUI waitForGUI = new WaitForGUI();

        String message = waitForGUI.getStringFromGUI();
        System.out.println(message); 

    }

    private JGetString getString = null;    
    private Waiter waiter;

    public WaitForGUI()
    {
        // Create the synchronization aid that will
        // allow waiting for the `JGetString` to 
        // be closed
        waiter = new Waiter();

        // Create the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                getString = new JGetString();

                ButtonListener listener = new ButtonListener(getString);
                getString.addActionListener(listener);

                getString.addActionListener(waiter);
            }
        });
    }

    // This method will block until the button in 
    // the `JGetString` was pressed.
    String getStringFromGUI()
    {
        waiter.waitFor();
        return getString.returnString();
    }


    private class ButtonListener implements ActionListener
    {
        JGetString getString;

        public ButtonListener(JGetString getString)
        {
            this.getString = getString;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            getString.setVisible(false);
        }
    }

    private static class Waiter implements ActionListener
    {
        private final CountDownLatch latch = new CountDownLatch(1);

        @Override
        public void actionPerformed(ActionEvent e)
        {
            latch.countDown();
        }

        void waitFor()
        {
            try
            {
                latch.await();
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class JGetString extends JFrame
{
    private JTextField textField;
    private JButton btnGet = new JButton("Get");

    public JGetString()
    {
        textField = new JTextField();
        getContentPane().add(textField, BorderLayout.CENTER);
        getContentPane().add(btnGet, BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }

    public void addActionListener(ActionListener act)
    {
        btnGet.addActionListener(act);

    }

    public String returnString()
    {
        return textField.getText();
    }

}