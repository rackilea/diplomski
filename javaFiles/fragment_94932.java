private void printToPrinter()
{
    String printData = CalculationTextArea.getText() + "\n" + SpecificTextArea.getText();
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(new OutputPrinter(printData));
    boolean doPrint = job.printDialog();
    if (doPrint)
    { 
        try 
        {
            job.print();
        }
        catch (PrinterException e)
        {
            // Print job did not complete.
        }
    }
}