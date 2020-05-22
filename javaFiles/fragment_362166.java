public static void main(String[] args) {
    JPanel mainContainer = new JPanel();
    mainContainer.setLayout(new BorderLayout());

    JFrame jf = new JFrame();  
    jf.add(mainContainer);

    JPanel browser = new JPanel();
    JLabel browserDummy = new JLabel("Browser");
    browser.add(browserDummy);
    browserDummy.setFont(new Font("Arial", Font.BOLD, 200));

    JPanel buttonContainer = new JPanel();
    buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
    buttonContainer.add(new JButton("Button one"));
    buttonContainer.add(new JButton("Button two"));

    mainContainer.add(browser, BorderLayout.WEST);
    mainContainer.add(buttonContainer, BorderLayout.EAST);

    jf.setVisible(true);
    jf.pack();
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}