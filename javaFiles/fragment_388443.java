public void actionPerformed(ActionEvent e) {
    enableButtons(0, 0, 0, 0); //0 disables, 1 enables one of four buttons
    Thread worker = new Thread(){
        public void run(){
            someFunction();
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    enableButtons(1, 1, 0, 0);
                }
            });
        }
    }
    worker.start();
}