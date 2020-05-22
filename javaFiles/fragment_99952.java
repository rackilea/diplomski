public class GenerateInvoice {

public static void printInvoice(String invoice) {
      try {
          PrintService mPrinter = null;
          Boolean bFoundPrinter = false;

          PrintService[] printServices = PrinterJob.lookupPrintServices();

          for (PrintService printService : printServices) {
              String sPrinterName = printService.getName();
              if (sPrinterName.equals("Black Cobra")) {
                  mPrinter = printService;
                  bFoundPrinter = true;
              }
          }
          String testData = invoice+"\f";
          InputStream is = new ByteArrayInputStream(testData.getBytes());
          DocFlavor flavor =  DocFlavor.INPUT_STREAM.AUTOSENSE   ;

          PrintService service = PrintServiceLookup.lookupDefaultPrintService();
          System.out.println(service);

          DocPrintJob job = service.createPrintJob();
          Doc doc= new SimpleDoc(is, flavor, null);

          PrintJobWatcher pjDone = new PrintJobWatcher(job);

          job.print(doc, null);

          pjDone.waitForDone();

          is.close();
      } catch (PrintException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  static class PrintJobWatcher {
      boolean done = false;

      PrintJobWatcher(DocPrintJob job) {
          // Add a listener to the print job
          job.addPrintJobListener(new PrintJobAdapter() {
              public void printJobCanceled(PrintJobEvent pje) {
                  allDone();
              }
              public void printJobCompleted(PrintJobEvent pje) {
                  allDone();
              }
              public void printJobFailed(PrintJobEvent pje) {
                  allDone();
              }
              public void printJobNoMoreEvents(PrintJobEvent pje) {
                  allDone();
              }
              void allDone() {
                  synchronized (PrintJobWatcher.this) {
                      done = true;
                      PrintJobWatcher.this.notify();
                  }
              }
          });
      }
      public synchronized void waitForDone() {
          try {
              while (!done) {
                  wait();
              }
          } catch (InterruptedException e) {
          }
      }
  }

}