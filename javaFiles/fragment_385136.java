import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sun.font.FontManager;

public class TestSplashScreen02 {

    public static void main(String[] args) {
        new TestSplashScreen02();
    }

    public TestSplashScreen02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                SwingWorker worker = new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {

                        SplashScreen splash = SplashScreen.getSplashScreen();
                        int width = 400;
                        int height = 300;
                        Graphics2D str = splash.createGraphics();
                        /******************************************************************/
                        str.setComposite(AlphaComposite.Clear);
                        str.fillRect(0, 0, width, height);
                        /******************************************************************/
                        str.setPaintMode();
                        str.setColor(Color.WHITE);
                        Font font = str.getFont().deriveFont(Font.BOLD, 24);
                        FontMetrics fm = str.getFontMetrics(font);
                        str.setFont(font);

                        String text = "Loading Login Class ...";

                        int x = (width - fm.stringWidth(text)) / 2;
                        int y = (height - fm.getHeight()) / 2;
                        str.drawString(text, x, y + fm.getAscent());

                        splash.update();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                        }
                        str.setComposite(AlphaComposite.Clear);
                        str.fillRect(0,0,400,300);
                        str.setPaintMode();

                        text = "Loading Main Class ...";

                        x = (width - fm.stringWidth(text)) / 2;
                        y = (height - fm.getHeight()) / 2;
                        str.drawString(text, x, y + fm.getAscent());
                        System.out.println("Update...");
                        splash.update();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                        }
                        splash.close();
                        return null;
                    }
                };

                worker.execute();
                try {
                    worker.get();
                } catch (InterruptedException | ExecutionException ex) {
                }

            }
        });
    }
}