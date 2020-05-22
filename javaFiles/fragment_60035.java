public MyClass() {
    private Button myButton = new Button();
    private ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //doSomething
        }
    };
    private initialize() {
        myButton.addActionListener(actionListener);
    }
}