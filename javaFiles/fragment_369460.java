public void start() {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                //test2 window = new test2();
                 frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}