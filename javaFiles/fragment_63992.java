public ExceptionTest()  {
    super("Exception Test");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e)throws RuntimeException {
            throw new RuntimeException("WindowClosedException");
        }
    });