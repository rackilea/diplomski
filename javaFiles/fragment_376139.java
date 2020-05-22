private static void WriteToWordWithLineBreak() {
    ArrayList<String> datatowrite = new ArrayList<String>();
    for (SPData data : qryresults) {
        datatowrite.add(data.toString());
    }
    try {
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(SOURCE_FILE));
        for (XWPFParagraph p : doc.getParagraphs()) {
            System.out.println("Found paragraph "+p);
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null) {
                        if (text.contains("$beta")) {
                            r.setText(datatowrite.get(0), 0);
                            for (int i=1; i < datatowrite.size(); i++){
                                r.addBreak();
                                r.setText(datatowrite.get(i));
                            }
                        }
                    }
                }
            }
        }
        doc.write(new FileOutputStream(OUTPUT_FILE));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}