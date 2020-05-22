public void sendToPrinter() {

        //Create new Task
        Task task = new Task<Boolean>() {
            @Override
            public Boolean call() {

                //Reference the PDF file
                File PDFFile = new File("File.pdf");

                try {
                    //Load PDF & create a Printer Job
                    PDDocument pd = PDDocument.load(PDFFile);
                    PrinterJob job = PrinterJob.getPrinterJob();
                    job.setPageable(new PDFPageable(pd));

                    //Show native print dialog & wait for user to hit "print"
                    if (job.printDialog()) {
                        job.print();
                    }

                    pd.close();
                } catch (IOException | PrinterException ex) {
                }

                return true;
            }
        };
        //Run task on new thread
        new Thread(task).start();

}