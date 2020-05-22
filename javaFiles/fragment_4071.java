class MainFrame extends JFrame {
    public MainFrame() {
        this.setLayout(new BorderLayout());
        this.setBounds(50, 50, 200, 300);
        this.setVisible(true);
        JPanel jp = new JPanel();
        jp.setBackground(Color.BLUE);
        this.add(jp, BorderLayout.CENTER);
        LogService logService = new LogService(this); // This object should be used in your control where you want clear panel
        //logService.removePanel(); // Comment and uncomment this line to see the difference. Change in blue color
    }

    public void hideLoginPanel() {
        this.removeAll();
        this.repaint();
    }

    public static void main(String args[]) {
        new MainFrame();
    }
}

class LogService {
    private  MainFrame mainFrame;

    public LogService(MainFrame mainFrame) {
        this.mainFrame=mainFrame;
    }

    public void removePanel(){
        mainFrame.hideLoginPanel(); // here's where I called the function
    }
}