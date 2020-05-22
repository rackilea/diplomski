import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ScalablePrintingTest {

    public static void main(String[] args) {
        new ScalablePrintingTest();
    }

    public ScalablePrintingTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final TestPane imagePane = new TestPane();
                JButton print = new JButton("Print");
                print.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            //printComponent(imagePane);
                            printComponentToFile(imagePane);
                        } catch (PrinterException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(imagePane);
                frame.add(print, BorderLayout.SOUTH);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage bg;

        public TestPane() {
            try {
                bg = ImageIO.read(new File("/path/to/a/image"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return bg == null ? new Dimension(200, 200) : new Dimension(bg.getWidth(), bg.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (bg != null) {
                int x = (getWidth() - bg.getWidth()) / 2;
                int y = (getHeight() - bg.getHeight()) / 2;
                g2d.drawImage(bg, x, y, this);
            }
            g2d.dispose();
        }
    }

    public void printComponent(Component comp) {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable(new ComponentPrintable(comp));

        if (!pj.printDialog()) {
            return;
        }
        try {
            pj.print();
        } catch (PrinterException ex) {
            System.out.println(ex);
        }
    }

    public static void printComponentToFile(Component comp) throws PrinterException {
        Paper paper = new Paper();
        paper.setSize(8.3 * 72, 11.7 * 72);
        paper.setImageableArea(18, 18, 559, 783);

        PageFormat pf = new PageFormat();
        pf.setPaper(paper);
        pf.setOrientation(PageFormat.LANDSCAPE);

        BufferedImage img = new BufferedImage(
                (int) Math.round(pf.getWidth()),
                (int) Math.round(pf.getHeight()),
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fill(new Rectangle(0, 0, img.getWidth(), img.getHeight()));
        ComponentPrintable cp = new ComponentPrintable(comp);
        try {
            cp.print(g2d, pf, 0);
        } finally {
            g2d.dispose();
        }

        try {
            ImageIO.write(img, "png", new File("Page-Scaled.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static class ComponentPrintable implements Printable {

        private Component comp;

        private ComponentPrintable(Component comp) {
            this.comp = comp;
        }

        @Override
        public int print(Graphics g, PageFormat pf, int pageNumber)
                throws PrinterException {
            // TODO Auto-generated method stub
            if (pageNumber > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            // Get the preferred size ofthe component...
            Dimension compSize = comp.getPreferredSize();
            // Make sure we size to the preferred size
            comp.setSize(compSize);
            // Get the the print size
            Dimension printSize = new Dimension();
            printSize.setSize(pf.getImageableWidth(), pf.getImageableHeight());

            // Calculate the scale factor
            double scaleFactor = getScaleFactorToFit(compSize, printSize);
            // Don't want to scale up, only want to scale down
            if (scaleFactor > 1d) {
                scaleFactor = 1d;
            }

            // Calcaulte the scaled size...
            double scaleWidth = compSize.width * scaleFactor;
            double scaleHeight = compSize.height * scaleFactor;

            // Create a clone of the graphics context.  This allows us to manipulate
            // the graphics context without begin worried about what effects
            // it might have once we're finished
            Graphics2D g2 = (Graphics2D) g.create();
            // Calculate the x/y position of the component, this will center
            // the result on the page if it can
            double x = ((pf.getImageableWidth() - scaleWidth) / 2d) + pf.getImageableX();
            double y = ((pf.getImageableHeight() - scaleHeight) / 2d) + pf.getImageableY();
            // Create a new AffineTransformation
            AffineTransform at = new AffineTransform();
            // Translate the offset to out "center" of page
            at.translate(x, y);
            // Set the scaling
            at.scale(scaleFactor, scaleFactor);
            // Apply the transformation
            g2.transform(at);
            // Print the component
            comp.printAll(g2);
            // Dispose of the graphics context, freeing up memory and discarding
            // our changes
            g2.dispose();

            comp.revalidate();
            return Printable.PAGE_EXISTS;
        }
    }

    public static double getScaleFactorToFit(Dimension original, Dimension toFit) {
        double dScale = 1d;
        if (original != null && toFit != null) {
            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);
            dScale = Math.min(dScaleHeight, dScaleWidth);
        }
        return dScale;
    }

    public static double getScaleFactor(int iMasterSize, int iTargetSize) {
        double dScale = 1;
        if (iMasterSize > iTargetSize) {
            dScale = (double) iTargetSize / (double) iMasterSize;
        } else {
            dScale = (double) iTargetSize / (double) iMasterSize;
        }
        return dScale;
    }
}