package com.txtlogger.logger.libraries;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintableLog implements Printable {

    private int[] pageBreaks;
    private String strContent;
    private String lineSeparator;
    private int pageVerticalMargin = 40;

    public PrintableLog(String strContent, String lineSeparator) {
        this.strContent = strContent;
        this.lineSeparator = lineSeparator;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        String[] content = getLinesFromContent(strContent);

        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null) {
            int linesPerPage = (int)((pageFormat.getImageableHeight()-pageVerticalMargin*2)/lineHeight);
            int numBreaks = (content.length-1)/linesPerPage;
            pageBreaks = new int[numBreaks];
            for (int b=0; b<numBreaks; b++) {
                pageBreaks[b] = (b+1)*linesPerPage;
            }
        }

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         */
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         */
        int y = pageVerticalMargin;
        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex-1];
        int end   = (pageIndex == pageBreaks.length)
                ? content.length : pageBreaks[pageIndex];
        for (int line=start; line<end; line++) {
            y += lineHeight;
            graphics.drawString(content[line], 40, y);
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;

    }

    private String[] getLinesFromContent(String content) {
        return content.split(this.lineSeparator);
    }
}