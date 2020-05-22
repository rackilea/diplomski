public class decodeWord {

 public static void main(String[] args) {

        FileInputStream fis = null;

        try {

            fis = new FileInputStream("/WORKSPACE/TestDoc.docx");
            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));

            List<AbstractXWPFSDT> sdts = extractAllSDTs(xdoc);
            for (AbstractXWPFSDT sdt : sdts) {
              System.out.println(sdt.getTag() + " " + sdt.getContent().getText());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<AbstractXWPFSDT> extractAllSDTs(XWPFDocument doc) {

        List<AbstractXWPFSDT> sdts = new ArrayList<AbstractXWPFSDT>();

        List<XWPFHeader> headers = doc.getHeaderList();
        for (XWPFHeader header : headers) {
            sdts.addAll(extractSDTsFromBodyElements(header.getBodyElements()));
        }
        sdts.addAll(extractSDTsFromBodyElements(doc.getBodyElements()));

        List<XWPFFooter> footers = doc.getFooterList();
        for (XWPFFooter footer : footers) {
            sdts.addAll(extractSDTsFromBodyElements(footer.getBodyElements()));
        }

        for (XWPFFootnote footnote : doc.getFootnotes()) {
            sdts.addAll(extractSDTsFromBodyElements(footnote.getBodyElements()));
        }
        return sdts;
    }

    private static List<AbstractXWPFSDT> extractSDTsFromBodyElements(List<IBodyElement> elements) {
        List<AbstractXWPFSDT> sdts = new ArrayList<AbstractXWPFSDT>();
        for (IBodyElement e : elements) {
            if (e instanceof XWPFSDT) {
                XWPFSDT sdt = (XWPFSDT) e;
                sdts.add(sdt);
            } else if (e instanceof XWPFParagraph) {

                XWPFParagraph p = (XWPFParagraph) e;
                for (IRunElement e2 : p.getIRuns()) {
                    if (e2 instanceof XWPFSDT) {
                        XWPFSDT sdt = (XWPFSDT) e2;
                        sdts.add(sdt);
                    }
                }
            } else if (e instanceof XWPFTable) {
                XWPFTable table = (XWPFTable) e;
                sdts.addAll(extractSDTsFromTable(table));
            }
        }
        return sdts;
    }

    private static List<AbstractXWPFSDT> extractSDTsFromTable(XWPFTable table) {

        List<AbstractXWPFSDT> sdts = new ArrayList<AbstractXWPFSDT>();
        for (XWPFTableRow r : table.getRows()) {
            for (ICell c : r.getTableICells()) {
                if (c instanceof XWPFSDTCell) {
                    sdts.add((XWPFSDTCell) c);
                } else if (c instanceof XWPFTableCell) {
                    sdts.addAll(extractSDTsFromBodyElements(((XWPFTableCell) c).getBodyElements()));
                }
            }
        }
        return sdts;
    }

}