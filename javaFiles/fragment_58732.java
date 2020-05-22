SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new JButton("text"));
        frame.setVisible(true);
    }
})