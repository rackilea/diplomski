for (JasperPrint jp : prints)
    {
        List<JRPrintPage> pages = jp.getPages();
        // Loop all pages of report
        for (JRPrintPage jpp : pages)
        {
            List<JRPrintElement> elements = jpp.getElements();
            // Loop all elements on page
            for (JRPrintElement jpe : elements)
            {
                System.out.println(jpe.getClass().getTypeName());
                // Check if text element
                if (jpe instanceof JRTemplatePrintFrame)
                {
                    JRTemplatePrintFrame jpf = (JRTemplatePrintFrame) jpe;
                    List<JRPrintElement> jpeElements = jpf.getElements();
                    for (JRPrintElement jpeElement : jpeElements)
                    {
                        if (jpeElement instanceof JRTemplatePrintText)
                        {
                            JRTemplatePrintText jpt = (JRTemplatePrintText) jpeElement;
                            // Check if current page marker
                            if (CURRENT_PAGE_NUMBER.equals(jpt.getValue()))
                            {
                                jpt.setText("Page " + currentPage + " of"); // Replace marker
                                continue;
                            }
                            // Check if total page marker
                            if (TOTAL_PAGE_NUMBER.equals(jpt.getValue()))
                            {
                                jpt.setText(" " + totPageNumber); // Replace marker
                            }
                        }
                    }
                }
            }
            currentPage++;
        }
    }