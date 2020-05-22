private Runnable delegate;

// ...
this.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        delegate.run();
    }
});

// ...
if (someVar == someVal) {
    this.delegate = new Runnable() {
        @Override
        public void run() {
            showSomeScreen();
        }
    };
}
else {
    this.delegate = new Runnable() {
        @Override
        public void run() {
            showSomeOtherScreen();
        }
    };
}