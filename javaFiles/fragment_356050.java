public class Test extends JFrame implements ActionListener, com.apple.eawt.AppReOpenedListener {

    public static void main(String[] args) {
        Test frame = new Test();
        JButton test = new JButton("test");
        test.addActionListener(frame);

        com.apple.eawt.Application app = com.apple.eawt.Application.getApplication();
        app.addAppEventListener(frame);

        frame.getContentPane().add(test);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        setVisible(false);

        //      try {
        //          Robot robot = new Robot();
        //          robot.keyPress(KeyEvent.VK_META);
        //          robot.keyPress(KeyEvent.VK_H);
        //          robot.keyRelease(KeyEvent.VK_H);
        //          robot.keyRelease(KeyEvent.VK_META);
        //      } catch (AWTException ex) {
        //          // TODO Auto-generated catch block
        //          ex.printStackTrace();
        //      }
    }

    @Override
    public void appReOpened(AppReOpenedEvent arg0) {
        setVisible(true);
    }
}