HWPFDocument document = [...];
SummaryInformation summaryInformation = document.getSummaryInformation();
System.out.println("GKPIDSI_CHARCOUNT: " + summaryInformation.getCharCount());

DocumentSummaryInformation documentSummaryInformation = document.getDocumentSummaryInformation();
Integer count = null;
for (Property property : documentSummaryInformation.getProperties()) {
    if (property.getID() == 0x11) {
            count = (Integer) property.getValue();
            break;
        }       
    }       
System.out.println("GKPIDDSI_CCHWITHSPACES: " + count);