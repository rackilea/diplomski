import javax.microedition.lcdui.*;

public class CanvasUnit extends Canvas {

    private int Top = 13, Left = 48;
    private int width = getWidth();
    private int height = getHeight();
    private static int SWidth = 10;
    private static int SHeight = 10;
    private int LStep = 5;
    private int TStep = 5;

    public CanvasUnit() {
        Thread t = new Thread(new Runnable() {

            public void run() {
                while (true) {

                    if (Left > (width - SWidth)) {
                        LStep = LStep * (-1);
                    } else if (Left < 0) {
                        LStep = Math.abs(LStep);
                    }
                    //
                    if (Top > (height - SHeight)) {
                        TStep = TStep * (-1);
                    } else if (Top < 0) {
                        TStep = Math.abs(TStep);
                    }

                    Left = Left + LStep;
                    Top = Top + TStep;

                    repaint();

                    try {
                        Thread.sleep(10);

                    } catch (Exception ex) {
                    }
                }
            }
        });
        t.start();
    }

    public void paint(Graphics g) {

        g.setColor(0, 0, 0);
        g.fillRect(0, 0, width, height);
        g.setColor(255, 255, 255);

        g.drawRect(Left, Top, SWidth, SHeight);
    }

}