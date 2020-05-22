public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            ...
            TestSwing testSwing = new TestSwing();
            frame.setContentPane(testSwing.mainPanel);
            frame.getRootPane().setDefaultButton(testSwing.sendButton);
            ...
        }
    });
}

public TestSwing() {                
}