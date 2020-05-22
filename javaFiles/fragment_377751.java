private void openAnexo() {
    new Thread () {
        @Override
        public void run() {
            for (int i = pnl.getWidth(); i <= 200; i++) {
                pnl.setPreferredSize(new Dimension(i, 300));
                pack();
            }
        }
    }.start();
}