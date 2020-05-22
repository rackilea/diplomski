// @Override
        public void actionPerformed(ActionEvent e) {

            new Thread() {
                @Override
                public void run() {
                    System.out.println("starting");
                    for (int i = 0; i < 1000; i++)
                    {
                        try
                        {
                            Thread.sleep(100);
                            System.out.println(Integer.toString(i));
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                     System.out.println("finishing");
                }
            }.start();