BUTTON.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            MAINFRAME.DOWNLOAD();
                        }
                    }).start();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });