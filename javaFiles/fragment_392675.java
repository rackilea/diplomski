public class test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();  
        JPanel mainPanel = new JPanel(new MigLayout());  
        mainPanel.add(new JButton(), "dock center");
        // or 
        //mainPanel.add(new JButton(), "dock center");

        frame.getContentPane().add(mainPanel);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}