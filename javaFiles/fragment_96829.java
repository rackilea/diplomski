import java.awt.*;
import java.awt.print.*;
import javax.swing.*;

public class PPanel extends JComponent implements Printable {

    private JComponent top = new TopHeader();
    private JComponent mid = new JLabel("Document Body");

    public PPanel() {
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(mid, BorderLayout.CENTER);
    }

    private static class TopHeader extends JComponent {

        public TopHeader() {
            this.setLayout(new BorderLayout());
            JLabel companyName = new JLabel("Company name");
            JLabel docType = new JLabel("Document type");
            this.add(companyName, BorderLayout.WEST);
            this.add(docType, BorderLayout.EAST);
        }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page)
        throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        int w = (int)pf.getImageableWidth();
        int h = (int)pf.getImageableHeight();
        top.setSize(new Dimension(w, top.getPreferredSize().height));
        this.setSize(w, h);
        this.validate();
        this.printAll(g2d);
        return PAGE_EXISTS;
    }

    public static void main(String[] args) {
        final PPanel p = new PPanel();
        // Preview before print()
        new JFrame() {
            {
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.add(p);
                this.pack();
                this.setVisible(true);
            }
        };
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.pageDialog(pj.defaultPage());
        pj.setPrintable(p, pf);
        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (PrinterException pe) {
                pe.printStackTrace();
            }
        }
    }
}