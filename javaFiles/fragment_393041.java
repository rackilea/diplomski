class PDFBackground extends PdfPageEventHelper {

    @Override
   public  void onEndPage(PdfWriter writer, Document document) {
                try {
                    Image background = Image.getInstance("F:/gmc_report.jpg");
                    background.setAbsolutePosition(250, 500);
                    // This scales the image to the page,
                    // use the image's width & height if you don't want to scale.
                    float width = document.getPageSize().getWidth();
                    float height = document.getPageSize().getHeight();
                    writer.getDirectContentUnder().addImage(background, false);
                } catch (DocumentException ex) {
                    Logger.getLogger(MoneryRecipt.class.getName()).log(Level.SEVERE, null, ex);
                }  catch (MalformedURLException ex) {
                    Logger.getLogger(MoneryRecipt.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MoneryRecipt.class.getName()).log(Level.SEVERE, null, ex);
                }
    }