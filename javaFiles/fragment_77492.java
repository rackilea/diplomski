import javax.swing.SwingUtilities;

public class CoinFlipApp extends JFrame {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            LayoutManager layoutManager = new BoxLayout(f.getContentPane(), BoxLayout.LINE_AXIS);
            f.getContentPane().setLayout(layoutManager);
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            f.setVisible(true);
            for (int i=0, j=5; i<j; i++) {
                CoinFlip coinFlip = new CoinFlip();
                f.getContentPane().add(coinFlip);
                executorService.submit(coinFlip);
            }
        });
    }
}



import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CoinFlip extends JLabel implements Runnable {

    @Override
    public void run() {
        final String value = Boolean.toString(randomBoolean()).toUpperCase();
        SwingUtilities.invokeLater(() -> {
            CoinFlip.this.setText(value);
            CoinFlip.this.repaint();
        });
    }

    private boolean randomBoolean() {
        try {
            // this can be removed later
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Math.random() < 0.5;
    }
}