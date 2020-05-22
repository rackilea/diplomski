public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(
        new Runnable() {
            @Override
            public void run() {
                try {
                    showLoadingBar();
                    Thread.sleep(10000L); // doing work in the EDT. Prevents the frame from animating
                    hideLoadingBar();
                }
                catch (InterruptedException e) {
                }
            }
        }
    );
}