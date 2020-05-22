package print_manager;

import icd_searcher.ResultContainer;
import java.awt.Point;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import others.MeasuredBox;


public class PrintManager
{
    private PrinterJob printerJob;
    private SimpleResultPrinter srp;


    /**
     * Print printable object.
     * 
     * @param toPrint
     */
    public void initPrint(ResultContainer resultToPrint)
    {
        printerJob = PrinterJob.getPrinterJob();

        PageFormat selectedArea = printerJob.pageDialog(printerJob.defaultPage());
        MeasuredBox margin = new MeasuredBox(new Point((int) selectedArea.getImageableX(), (int) selectedArea.getImageableY()), (int) selectedArea.getImageableWidth(), (int) selectedArea.getImageableHeight() - 72);
        srp = new SimpleResultPrinter(resultToPrint, margin);

        SimpleResultPrinterSimulator srpSimulation = new SimpleResultPrinterSimulator(resultToPrint, margin);

        // total pages simulation
        int totalPages = 0;
        try
        {
            while (srpSimulation.print(selectedArea, totalPages) != Printable.NO_SUCH_PAGE)
            {
                totalPages++;
            }
        }
        catch (PrinterException e)
        {
            e.printStackTrace();
        }

        printerJob.setPrintable(srp, widenedPage);

        if (printerJob.printDialog())
        {
            try
            {
                printerJob.print();
            }
            catch (PrinterException exc)
            {
                System.out.println(exc);
            }
        }
    }
}