public class TestTest
{
    private JFrame mainFrame;
    private JPanel panelX;
    private String test;

    private static final Lock lock = new ReentrantLock();
    private static final Condition valueAssigned  = lock.newCondition();

    public static void main(String[] args) throws InterruptedException
    {
        TestTest run = new TestTest();
        run.GUIinit();
        run.addButton();

        // Acquire the lock.
        lock.lock();
        try {
            while (run.returnData() == null) {
                // Release the lock and wait for signal.
                valueAssigned.await();
            }
            // Once String value is set, print it.
            System.out.println(run.returnData());
        } finally {
            lock.unlock();
        }
    }

    // Method to return string value
    public String returnData()
    {
        return test;
    }

    // Method to set string value
    public void setData(String data)
    {
        test = data;
    }

    private void GUIinit()
    {
        mainFrame = new JFrame("Text");
        mainFrame.setSize(200, 200);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }
        });
        panelX = new JPanel();
        mainFrame.add(panelX);
        mainFrame.setVisible(true);
    }

    // Problematic part
    private void addButton()
    {
        JButton testButton = new JButton("Text");
        panelX.add(testButton);
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                setData("STRING BLABLA");

                // Acquire the lock.
                lock.lock();
                try {
                    // Send a signal to all waiting threads.
                    valueAssigned.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        });
    }
}