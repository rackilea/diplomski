startServerButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    startServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
});