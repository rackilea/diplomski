//Get the printer job
PrinterJob printJob = PrinterJob.getPrinterJob();
//Get the default PageFormat
PageFormat pf = printJob.defaultPage();
//Get a copy of the formats paper object
Paper copy = pf.getPaper();
//Change properties of the copy
copy.setSize(200, pf.getHeight());
//Since we only changed the copy, we need to set the PageFormats Paper Object to the copy
pf.setPaper(copy);