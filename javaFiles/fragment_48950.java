public static void main(String args[]) throws Exception {

String webUrl = "http://ramp.sdr.co.za/cache/1402NYFW/GoRedForWomen/";
URL url = new URL(webUrl);
URLConnection connection = url.openConnection();
InputStream is = connection.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);

HTMLEditorKit htmlKit = new HTMLEditorKit();
HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
htmlKit.read(br, htmlDoc, 0);

for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.A); iterator.isValid(); iterator.next()) {
    AttributeSet attributes = iterator.getAttributes();
    String imgSrc = (String) attributes.getAttribute(HTML.Attribute.HREF);

    System.out.println(imgSrc);
    if (imgSrc != null && (imgSrc.toLowerCase().endsWith(".jpg") || (imgSrc.endsWith(".png")) || (imgSrc.endsWith(".jpeg")) || (imgSrc.endsWith(".bmp")) || (imgSrc.endsWith(".ico")))) {
        try {
            downloadImage(webUrl, imgSrc);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}