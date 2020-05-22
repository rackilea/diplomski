for (PdfBean pdfBean : list)
            {
                if(!pdfBean.getFileName().isEmpty()&&!pdfBean.getFileLocation().isEmpty()){


                msgDH.InsertUserHistDtls(pdfBean.getHawb(), userId, pdfBean.getCustomer(), pdfBean.getFileName(), pdfBean.getProduct(), pdfBean.getDocType(), "Print");
                msgDH.InsertLogDtls(pdfBean.getFileName(), pdfBean.getProduct(), pdfBean.getCustomer(), userId);

                FTPClient ftp = new FTPClient();
                int tiffPages = 0;
                try
                {
                    ftp.connect(ftpserver);
                } catch (SocketException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                try
                {
                    boolean login = ftp.login(ftpusername, ftppassword);
                } catch (IOException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                int reply;
                reply = ftp.getReplyCode();
                if (!FTPReply.isPositiveCompletion(reply))
                {
                    ftp.disconnect();
                    System.out.println("FTP server refused connection.");
                } else
                {
                    // ftp.enterLocalPassiveMode();
                    ftp.enterLocalActiveMode();
                    ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
                    ftp.changeWorkingDirectory(pdfBean.getFileLocation());
                    /* FTPFile[] */
                    ftpFiles = ftp.listFiles();
                    /* FTPFile[] */// ftpFiles = ftp.listFiles();
                    // ftp.completePendingCommand();
                }

                String fileName = pdfBean.getFileLocation() + "/"
                        + pdfBean.getFileName();
                if ("/interface/oracle/dds/generic/hold/TIF"
                        .equalsIgnoreCase(pdfBean.getFileLocation()))
                {
                    int i = 0;
                    String F = pdfBean.getFileName().replaceAll(".PDF",
                            ".TIF");
                    // FTPFile[] ftpFiles =
                    // ftp.listFiles(pdfBean.getFileLocation());
                    for (FTPFile ftpFile : ftpFiles)
                    {
                        if (ftpFile.getName().equals(F))
                        {
                            fileName = pdfBean.getFileLocation()
                                    .concat("/").concat(F);
                            i = 1;
                        }

                    }
                    if (i == 0)
                    {
                        F = pdfBean.getFileName().replaceAll(".PDF",
                                ".TIFF");
                        for (FTPFile ftpFile : ftpFiles)
                        {
                            if (ftpFile.getName().equals(F))
                            {
                                fileName = pdfBean.getFileLocation()
                                        .concat("/").concat(F);
                                i = 1;
                            }

                        }
                    }
                    int Repcode = ftp.getReplyCode();
                    //
                    // System.out.println(Repcode);
                    /* if(fileName.endsWith(".TIF")) */

                    InputStream is = (InputStream) ftp.retrieveFileStream(fileName);
                    Repcode = ftp.getReplyCode();
                    System.out.println(Repcode);
                    // ftp.completePendingCommand();
                    Repcode = ftp.getReplyCode();
                    System.out.println(Repcode);
                    ra1 = new RandomAccessFileOrArray(is);
                    tiffPages = TiffImage.getNumberOfPages(ra1);
                    System.out.println("No of pages in image is : "
                            + tiffPages);
                    for (int a = 1; a <= tiffPages; a++)
                    {
                        try
                        {
                            Image img = TiffImage.getTiffImage(ra1, a);
                            if (img != null)
                            {
                                if (img.getScaledWidth() > 500
                                        || img.getScaledHeight() > 700)
                                {
                                    img.scaleToFit(800, 800);
                                }
                                doc.setPageSize(new Rectangle(img
                                        .getScaledWidth(), img
                                        .getScaledHeight()));
                                img.setAbsolutePosition(0, 0);
                                cb.addImage(img);
                                // doc.
                                doc.newPage();
                                // ++pages;
                            }
                        } catch (Throwable e)
                        {
                            System.out.println("Exception " + " page "
                                    + (a + 1) + " " + e.getMessage());
                        }
                    }
                    is.close();
                    ra1.close();

                }
                else{

                    InputStream pdf = ftp.retrieveFileStream(fileName);
                    if(pdf != null) {
                        PdfReader pdfRea = new PdfReader(pdf);
                        readers.add(pdfRea);
                        totalPages += pdfRea.getNumberOfPages();   
                    }


                    /*totalPages += pdfRea.getNumberOfPages();


                    PdfImportedPage page;
                    int currentPageNumber = 0;
                    int pageOfCurrentReaderPDF = 0;
                    Iterator<PdfReader> iteratorPDFReader = readers.iterator();

                    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
                            BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                   // Loop through the PDF files and add to the output.
                   while (iteratorPDFReader.hasNext()) {
                       PdfReader pdfReader = iteratorPDFReader.next();

                       // Create a new page in the target for each source page.
                       while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
                           doc.newPage();
                           pageOfCurrentReaderPDF++;
                           currentPageNumber++;
                           page = write.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
                           cb.addTemplate(page, 0, 0);

                           // Code for pagination.
                           cb.beginText();
                           cb.setFontAndSize(bf, 9);
                           cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
                                   + currentPageNumber + " of " + totalPages, 520, 5, 0);
                           cb.endText();
                       }
                       pageOfCurrentReaderPDF = 0;
                   }*/
                }

                ftp.logout();
                ftp.disconnect();
                ftp = null;
            }}



            PdfImportedPage page;
            int currentPageNumber = 0;
            int pageOfCurrentReaderPDF = 0;
            Iterator<PdfReader> iteratorPDFReader = readers.iterator();

            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
           // Loop through the PDF files and add to the output.
           while (iteratorPDFReader.hasNext()) {
               PdfReader pdfReader = iteratorPDFReader.next();

               // Create a new page in the target for each source page.
               while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
                   doc.newPage();
                   pageOfCurrentReaderPDF++;
                   currentPageNumber++;
                   page = write.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
                   cb.addTemplate(page, 0, 0);

                   // Code for pagination.
                   cb.beginText();
                   cb.setFontAndSize(bf, 9);
                   cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
                           + currentPageNumber + " of " + totalPages, 520, 5, 0);
                   cb.endText();
               }
               pageOfCurrentReaderPDF = 0;
           }
        }
        doc.close();
        write.flush();
        write.close();
        System.out.println("done printing");

    }


    FileInputStream fiss = new FileInputStream(temp);  
    bis = new BufferedInputStream(fiss);
    response.reset();