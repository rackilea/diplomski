frame = new JFrame();
    frame.setResizable(false);
    frame.setBounds(100, 100, 552, 444);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    final CheckPort checkPort = new CheckPort();
    final Thread thread = new Thread( checkPort );
    thread.start();
    frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing( WindowEvent e ) {
            checkPort.stop();
            thread.interrupt();
        }
    });