class Example implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Example());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        // setup
        frame.setVisible(true);
    }
}