public static void main(String[] args) {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(
                    "C:/users/XY/desktop/XY/Dotted.pdf"));

            document.open();

            String text = "The test file for Kids";
            Font font = new Font(BaseFont.createFont("C:/Workspace/kg_primary_dots/KGPrimaryDotsLined.ttf",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 72, Font.NORMAL);

            Paragraph para = new Paragraph(text, font);

            document.add(para);
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        document.close();
    }