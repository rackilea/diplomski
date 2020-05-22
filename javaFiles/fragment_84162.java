import javax.swing.Timer;
import java.awt.event.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Fac {
    public static int fac(final int _n) {
        final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
        final Timer timer = new Timer(0, null);
        timer.addActionListener(new ActionListener() {
            int result = 1;
            int n = _n;
            public void actionPerformed(ActionEvent e) {
                result *= n;
                n--;
                if(n == 0) {
                    try {
                        queue.put(result);
                    } catch(Exception ex) {
                    }
                    timer.stop();
                }
            }
        });
        timer.start();
        int result = 0;
        try {
            result = queue.take();
        } catch(Exception ex) {
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fac(10));
    }
}