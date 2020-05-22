import java.awt.print.*;

import javax.print.PrintService;
import javax.print.attribute.Attribute;

public class DetectFilePrinter {

  public static void main(String[] args) {
    PrinterJob job = PrinterJob.getPrinterJob();
    PrintService printer = job.getPrintService();
    System.out.println("Printer Name:"+printer.getName());

    System.out.println(printer.toString());
    PageFormat page = job.defaultPage();
    double default_width = page.getWidth();
    double default_height = page.getHeight();

    Paper paper = new Paper();
    paper.setImageableArea(0, 0, Double.MAX_VALUE, Double.MAX_VALUE);
    page.setPaper(paper);

    PageFormat fixed_page = job.validatePage(page);

    double fixed_width = fixed_page.getImageableWidth();
    double fixed_height = fixed_page.getImageableHeight();

    //So far all of my tested "image printers" return the same 
    //height and width after calling validatePage()
    if(default_height == fixed_height && default_width == fixed_width) {
      System.out.println("This looks like a \"image printer\"");
    } else {
      System.out.println("This looks like a \"real printer\"");
    }
  }
}