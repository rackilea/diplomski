JButton btnTestIoexception = new JButton("Test IOException");
    btnTestIoexception.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            testExceptions("Hi","http://www.itb.ie","Whatever.txt", false);
        }
    });
    btnTestIoexception.setBounds(115, 50, 180, 23);
    contentPane.add(btnTestIoexception);

    JButton btnTestUrlException = new JButton("Test Url Exception");
    btnTestUrlException.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            testExceptions("Hi","","Real.txt", false);
        }
    });
    btnTestUrlException.setBounds(115, 99, 180, 23);
    contentPane.add(btnTestUrlException);

    JButton btnTestNullpointerexception = new JButton("Test NullPointerException");
    btnTestNullpointerexception.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                testExceptions(null,"http://www.itb.ie","Real.txt",false);
        }
    });
    btnTestNullpointerexception.setBounds(115, 152, 180, 23);
    contentPane.add(btnTestNullpointerexception);

    JButton btnGeneralException = new JButton("Test General Exception");
    btnGeneralException.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            testExceptions("","http://www.itb.ie","Real.txt", true);
        }
    });