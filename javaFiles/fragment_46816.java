btnPrint.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        //Code revised from https://stackoverflow.com/questions/14775753/printing-multiple-jtables-as-one-job-book-object-only-prints-1st-table?rq=1
                        // \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
                        PrinterJob printerJob = PrinterJob.getPrinterJob();

                        //Set 1/4 " margins and orientation
                        PageFormat pf = printerJob.defaultPage();
                        pf.setOrientation(PageFormat.LANDSCAPE);
                        Paper paper = new Paper();
                        //double margin = 36; // half inch
                        double margin = 18; // quarter inch
                        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
                        pf.setPaper(paper);

                        Book bookToPrint = new Book();
                        // /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
                        //Code revised from https://stackoverflow.com/questions/14775753/printing-multiple-jtables-as-one-job-book-object-only-prints-1st-table?rq=1

                        // List to store temporary tables to print
                        List<JTable> tablesToPrint = new ArrayList<JTable>();

                        // create temporary print tables by wrapping line number
                        int wrappingLineNumber = (Integer) table.getValueAt(0, 0);
                        WrappingSheetsTableModel printModel = new WrappingSheetsTableModel();
                        for (int i = 0; i < table.getRowCount(); i++) {
                            if ((Integer)table.getValueAt(i, 0) == wrappingLineNumber) {
                                // add wrapping sheet row to print model
                                printModel.addRow((WrappingSheets) table.getValueAt(i, -1));
                            } else {
                                // if not the same, i.e., value changed
                                // create a new table
                                JTable toPrint = new JTable(printModel);

                                // set size of table as if size isn't set the table contents aren't printed
                                toPrint.setSize(toPrint.getPreferredSize());
                                // reduce row height for printing
                                toPrint.setRowHeight(16);
                                // add table to print to list of tables to be printed
                                tablesToPrint.add(toPrint);

                                // create a new print model for next table to be printed
                                printModel = new WrappingSheetsTableModel();
                                // add first new wrapping sheet row to print model
                                printModel.addRow((WrappingSheets) table.getValueAt(i, -1));
                                // increment the wrapping line number
                                wrappingLineNumber = (Integer) table.getValueAt(i, 0);
                            }
                        }
                        // add in last table to print
                        JTable toPrint = new JTable(printModel);
                        // set size of table as if size isn't set the table contents aren't printed
                        toPrint.setSize(toPrint.getPreferredSize());
                        // reduce row height for printing
                        toPrint.setRowHeight(16);

                        // add last table to print to list of tables to be printed
                        tablesToPrint.add(toPrint);

                        // add each table to be printed to book for printing
                        int totalPages = 0;
                        for (JTable table : tablesToPrint) {
                            // get the table header information from table
                            JTableHeader tableHeader = table.getTableHeader();
                            // set size so that table header will be visible
                            tableHeader.setSize(tableHeader.getPreferredSize());

                            // get number of pages in printable table
                            int pages = getNumberOfPages(table.getPrintable(PrintMode.FIT_WIDTH, null, null), pf);

                            // create temporary printable to add to book
                            Printable p = table.getPrintable(PrintMode.FIT_WIDTH, null, null);
                            // add printable to book using printable wrapper
                            // p - printable, totalPages - total pages, pf - page format, pages - num pages to add
                            bookToPrint.append(new PrintableWrapper(p, totalPages), pf, pages);

                            // increase total pages count
                            totalPages += pages;
                        }

                        //Checks for page count:
                        //System.out.println(totalPages);
                        //System.out.println(bookToPrint.getNumberOfPages());

                        // Queries document for the number of pages 
                        // and the PageFormat 
                        // and Printable 
                        // for each page held in the Pageable instance, document.
                        printerJob.setPageable(bookToPrint);

                        // show print dialog
                        // - printer selection and pages to print work
                        // - changing from e.g. landscape to portrait does not work currently
                        if(printerJob.printDialog()) printerJob.print();

                        System.out.println("success printing X");
                    } catch (PrinterException pe) {
                        System.out.println("printing failed");
                        pe.printStackTrace();
                    }
                };
            });