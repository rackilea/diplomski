JButton startServer = new JButton();
    startServer.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Runtime runtime = Runtime.getRuntime();
            try {
                // Here exec your bat file
                runtime.exec("Path_To_Your_Bat_File");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    });

    JButton stopServer = new JButton();
    stopServer.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Runtime runtime = Runtime.getRuntime();
            try {
                //Here get your process id and kill it
                runtime.exec("Get_Process & Kill");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    });