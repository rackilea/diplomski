ScreenDemo extends JFrame implements ActionListener
    ...
        btn1.addActionListener(this);
        btn2.addActionListener(this);
    ...
        @override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource().equals(btn1)) {
            ...
            }
            else if(ae.getSource().equals(btn1)) {
            ...
            }
        }