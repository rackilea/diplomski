public class Main
{

    public Main()
    {
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat format = job.pageDialog(job.defaultPage());
        job.setPrintable(new Text(), format);

        if (job.printDialog())
        {
            try
            {
                job.print();
            }
            catch (PrinterException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}

class Text implements Printable
{
    int textPosY;

    @Override
    public int print(Graphics g, PageFormat format, int index) throws PrinterException
    {
        if (index > 0)
            return Printable.NO_SUCH_PAGE;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.translate(format.getImageableX(), format.getImageableY());

        g2d.setPaint(Color.GREEN);
        g2d.fill(new Rectangle2D.Double(0, 10, format.getWidth(), g2d.getFontMetrics().getHeight() * 2));

        /* Header */
        g2d.setColor(Color.BLACK);
        textPosY = 10 + g2d.getFontMetrics().getAscent();
        g2d.drawString("Information", 30, textPosY);
        textPosY += g2d.getFontMetrics().getDescent() + g2d.getFontMetrics().getLeading() + g2d.getFontMetrics().getAscent();
        g2d.drawString("More information", 40, textPosY);

        return Printable.PAGE_EXISTS;
    }
}