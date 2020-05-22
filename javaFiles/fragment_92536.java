public static void main(String[] args) {
    ...
    frame.setContentPane(new TestSwing().mainPanel);
    ...
}

public TestSwing() {                
    mainPanel.getRootPane().setDefaultButton(sendButton);
}