try {

            // get Instance of the PDFWriter
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(
                    path));
            //pdfWriter.setPdfVersion(PdfWriter.PDF_VERSION_1_4);
            pdfWriter.setLinearPageMode();
            pdfWriter.setFullCompression();


            // document header attributes
            document.addAuthor("");
            document.addCreationDate();
            document.addProducer();
            document.addCreator("aaa");
            document.addTitle("");
            document.setPageSize(PageSize.A4);

            // open document
            document.open();

            HTMLWorker htmlWorker = new HTMLWorker(document);

            String str = "";
            StringBuilder contentBuilder = new StringBuilder();
            BufferedReader in = null;

            System.out.println("Html Content :");
            try {
                in = new BufferedReader(new FileReader(
                        htmlfile));

                while ((str = in.readLine()) != null) {

                    contentBuilder.append(str);
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.out.print("HTML file close problem:" + e.getMessage());
            } finally {

                in.close();
                System.gc();
            }
            String content = contentBuilder.toString();

            htmlWorker.parse(new StringReader(content));

            document.close();

            pdfWriter.close();


        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }