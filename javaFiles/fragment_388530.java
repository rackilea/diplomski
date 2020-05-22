//First loop on all reports to get totale page number
int totPageNumber=0;
for (JasperPrint jp : jasperPrintList) {
    totPageNumber += jp.getPages().size();
}

//Second loop all reports to replace our markers with current and total number
int currentPage = 1;
for (JasperPrint jp : jasperPrintList) {
    List<JRPrintPage> pages = jp.getPages();
    //Loop all pages of report
    for (JRPrintPage jpp : pages) {
        List<JRPrintElement> elements = jpp.getElements();
        //Loop all elements on page
        for (JRPrintElement jpe : elements) {
            //Check if text element
            if (jpe instanceof JRPrintText){
                JRPrintText jpt = (JRPrintText) jpe;
                //Check if current page marker
                if (CURRENT_PAGE_NUMBER.equals(jpt.getValue())){
                    jpt.setText("Page " + currentPage + " of"); //Replace marker
                    continue;
                }
                //Check if totale page marker
                if (TOTAL_PAGE_NUMBER.equals(jpt.getValue())){
                    jpt.setText(" " + totPageNumber); //Replace marker
                }
            }
        }
        currentPage++;
    }
}