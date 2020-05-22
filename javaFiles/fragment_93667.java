public void actionPerformed(ActionEvent e) {
    sinoButton.setText("Loading Sinogram");
    new Thread() {
        public void run(){
            NotifyObserversSinogram();
        }
    }.start();
}