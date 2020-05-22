@Override
public void actionPerformed(ActionEvent evt) {
    Thread thread = new Thread() {
        @Override
        public void run() {
            //Some code
        }
    };
    thread.start();
}