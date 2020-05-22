private final Action exitAction = new AbstractAction("Exit")
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    };
private final Action minimizeAction = new AbstractAction("Minimize")
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            setState(JFrame.ICONIFIED);
        }
    };