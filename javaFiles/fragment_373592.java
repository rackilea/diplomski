@Override
    public void actionPerformed(ActionEvent event) 
    {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ... // All code here
            }
        });
    }