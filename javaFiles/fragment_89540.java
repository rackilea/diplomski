import java.awt.Font;
    import javax.swing.JFrame;
    import javax.swing.JLabel;

        /**
         * @author Rakesh KR
         */

    public class SimpleGUI1 {



        public static void main(String[] args) {
            SimpleGUI1 gUI = new SimpleGUI1();
            gUI.action();
        }

        void action(){
            JFrame  frame  = new JFrame();
            JLabel label = new JLabel("രാകേഷ്");
            // Can also use unicode 
            //JLabel label= new JLabel("\u0d30\u0d3e\u0d15\u0d47\u0d37\u0d4d");
            Font font = new Font("Arial Unicode MS", Font.PLAIN, 12);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            label.setFont(font);
            frame.add(label);
            frame.setSize(100,100);
            frame.setVisible(true);
            PrinterJob pj = PrinterJob.getPrinterJob();
            pj.setJobName(" Print Component ");

            pj.setPrintable(new Printable() {
                public int print(Graphics pg, PageFormat pf, int pageNum) {
                    if (pageNum > 0) {
                        return Printable.NO_SUCH_PAGE;
                    }
                    Dimension dim = frame.getSize();
                    double cHeight = dim.getHeight();
                    double cWidth = dim.getWidth();

                    // get the bounds of the printable area
                    double pHeight = pf.getImageableHeight();
                    double pWidth = pf.getImageableWidth();

                    double pXStart = pf.getImageableX();
                    double pYStart = pf.getImageableY();

                    double xRatio = pWidth / cWidth;
                    double yRatio = pHeight / cHeight;

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pXStart, pYStart);
                    g2.scale(xRatio, xRatio);
                    frame.paint(g2);
                    return Printable.PAGE_EXISTS;
                    }
                });

                try {
                    if (pj.printDialog()) {
                            pj.print();
                        }
                    } catch (PrinterException ex) {

                    }
                }
        }
}