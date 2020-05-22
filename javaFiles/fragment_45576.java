PrinterJob pj = PrinterJob.getPrinterJob();
PageFormat format = pj.getPageFormat(null);
Paper paper = format.getPaper();
//Remove borders from the paper
paper.setImageableArea(0.0, 0.0, format.getPaper().getWidth(), format.getPaper().getHeight());
format.setPaper(paper);

pj.setPrintable(new Printable()
{
    @Override
    public int print(Graphics pg, PageFormat pf, int pageNum)
            throws PrinterException
    {
        if (pageNum > 0)
            return Printable.NO_SUCH_PAGE;

        Graphics2D g2 = (Graphics2D)pg;
        g2.translate(pf.getImageableX(), pf.getImageableY());
        int textHeight = g2.getFontMetrics().getHeight();
        g2.drawString("Good morning, what will be for eating?", 0, textHeight);
        return Printable.PAGE_EXISTS;
    }
}, format);

if (!pj.printDialog())
    return;

pj.print();