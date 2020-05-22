public class progress {
    public static void main(String[] args) throws InterruptedException {
        mgfinancewindow load = new mgfinancewindow();
        for (int i = 0; i <= 100; i++) {
            Thread.sleep(150);
            //load.setvisible(true);
            load.lblNewLabel.setText("Loading..." + i);
            load.progressBar.setValue(i);
        }
    }
}