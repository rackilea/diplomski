JFrame frame = new JFrame();

    JButton button = new JButton("Click Here");
    frame.add(new JButton("Click Here"){
        @Override
        public void addActionListener(ActionListener l) {
            super.addActionListener(YourClass.this);
        }
    });