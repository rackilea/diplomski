import com.mortennobel.imagescaling.ProgressListener;
import com.mortennobel.imagescaling.ResampleOp;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    protected JLabel message;

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                message = new JLabel("Rescampling, wait for it...");
                message.setHorizontalAlignment(JLabel.CENTER);
                message.setBorder(new EmptyBorder(10, 10, 10, 10));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(message);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ResampleWorker worker = new ResampleWorker();
                worker.execute();
            }
        });
    }

    public class ResampleWorker extends SwingWorker<String, String> {

        @Override
        protected String doInBackground() throws Exception {
            ProgressMonitor pm = new ProgressMonitor(null, "Scaling", "Please wait...", 0, 100);
            File source = new File("C:\\Users\\shane\\Downloads\\1713601.jpg");
            try {
                System.out.println("Reading...");
                publish("Reading source image...");
                BufferedImage img = ImageIO.read(source);

                int toWidth = img.getWidth() * 10;
                int toHeight = img.getHeight()* 10;

                System.out.println("From..." + (img.getWidth()) + "x" + (img.getHeight()));
                System.out.println("to..." + toWidth + "x" + toHeight);
                publish("Resample..." + toWidth + "x" + toHeight);
                ResampleOp op = new ResampleOp(toWidth, toHeight);
                Thread.yield();
                op.addProgressListener(new ProgressListener() {
                    public void notifyProgress(float fraction) {
                        int p = (int) (fraction * 100);
                        pm.setProgress(p);
//                        System.out.println(p);
                    }
                });
                BufferedImage scaled = op.filter(img, null);
                pm.close();
//                File dest = new File("scaled.jpg");
//                ImageIO.write(scaled, "jpg", dest);
//                JTextField field = new JTextField(dest.getCanonicalPath());
//                JOptionPane.showMessageDialog(null, field);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to load - " + ex.getMessage());
            }
            publish("Done...");
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            message.setText(chunks.get(chunks.size() - 1));
            message.revalidate();
            message.repaint();
        }

        @Override
        protected void done() {
            try {
                get();
                JOptionPane.showMessageDialog(null, "All done");
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            }
            System.exit(0);
        }


    }

}