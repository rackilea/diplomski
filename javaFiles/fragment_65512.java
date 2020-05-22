public class Main extends JPanel implements ActionListener {
    BufferedImage img;
    int number;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Some practice");
        Runnable doRun = new Runnable() {
            @Override
            public void run() {
                frame.setSize(200, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Main doStuff = new Main();

                JButton myButton = new JButton("Button");
                myButton.addActionListener(doStuff);
                JPanel controls = new JPanel();
                controls.setBorder(BorderFactory
                        .createTitledBorder("Small Panel"));
                controls.add(myButton);
                frame.add("South", controls);
                frame.add(doStuff);
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(doRun);
    }

    public Main() {
        super.setBorder(BorderFactory.createTitledBorder("Big Panel!"));
        final String imgPath = "res/strawberry.jpg";
        // This method seems to shut down my GUI
        add(new ImagePanel(imgPath));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}