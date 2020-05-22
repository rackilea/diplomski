button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Runnable r = new Runnable() {

                public void run() {
                        progressBar.setIndeterminate(true);
                        progressBar.setVisible(true);
                        progressBar.setStringPainted(true);
                        progressBar.setString("Searching..");

                    //Process to search for files

                        progressBar.setIndeterminate(false);
                        progressBar.setString("Completed Search");

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    });