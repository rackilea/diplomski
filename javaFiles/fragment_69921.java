public class TimerThreads implements ActionListener {

    JFrame jFrame = new JFrame();
    JLabel[] labels;
    // int second = 0;
    // int minute = 0;
    // String s = "";
    // String m = "";
    int l = 0;

    public TimerThreads() {
        //.....
    }

    // ....


    class TimerThread extends Thread {
        JLabel jLabel;

        public TimerThread(JLabel jLabel) {
            this.jLabel = jLabel;
        }

        @Override
        public void run() {
            java.util.Timer timer = new java.util.Timer();
            timer.scheduleAtFixedRate(new TimerTask() {

                // ***** add these fields here
                int second = 0;
                int minute = 0;
                String s = "";
                String m = "";