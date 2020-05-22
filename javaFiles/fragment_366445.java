import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextAreaScroller
{
    private JTextArea msgArea;
    private JScrollPane msgScroller;
    private JTextArea logArea;
    private JScrollPane logScroller;
    private JButton sendButton;
    private JButton terminateButton;
    private Timer timer;
    private int counter = 0;
    private String[] messages = {
                                    "Hello there\n",
                                    "How you doing ?\n",
                                    "This is a very long text that might won't fit in a single line :-)\n",
                                    "Okay just to occupy more space, it's another line.\n",
                                    "Don't read too much of the messages, instead work on the solution.\n",
                                    "Byee byee :-)\n",
                                    "Cheers\n"
                                };

    private ActionListener timerAction = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if (counter < messages.length)
                msgArea.append(messages[counter++]);
            else
                counter = 0;
        }
    };

    private void displayGUI()
    {
        JFrame frame = new JFrame("Chat Messenger Dummy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1, 5, 5));

        logArea = new JTextArea(10, 10);
        logArea.setWrapStyleWord(true);
        logArea.setLineWrap(true);      

        logScroller = new JScrollPane();        
        logScroller.setBorder(
            BorderFactory.createTitledBorder("Chat Log"));
        logScroller.setViewportView(logArea);

        msgArea = new JTextArea(10, 10);
        msgArea.setWrapStyleWord(true);
        msgArea.setLineWrap(true);      

        msgScroller = new JScrollPane();        
        msgScroller.setBorder(
            BorderFactory.createTitledBorder("Messages"));
        msgScroller.setViewportView(msgArea);

        centerPanel.add(logScroller);
        centerPanel.add(msgScroller);

        JPanel bottomPanel = new JPanel();

        terminateButton = new JButton("Terminate Session");
        terminateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (timer.isRunning())
                    timer.stop();
                else
                    timer.start();
            }
        });
        sendButton = new JButton("Send");

        bottomPanel.add(terminateButton);
        bottomPanel.add(sendButton);

        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        timer = new Timer(1000, timerAction);
        timer.start();
    }

    public static void main(String... args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new JTextAreaScroller().displayGUI();
            }
        });
    }
}