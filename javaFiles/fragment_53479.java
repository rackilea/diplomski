public class MatrixSheet1 {
    Properties p;
    File file;
    Document document;
    PdfWriter writer;
    Image logo = null;
    Image EANimg = null;
    float mnoz = new Double(72/25.6).floatValue();

    int IMG_WIDTH= new Double(35*mnoz).intValue(); 
    int IMG_HEIGHT=new Double(35*mnoz).intValue();
    String err=p.getProperty("cell.height");
    systemMessage("Argh!");
    float cell_Height = Float.parseFloat(p.getProperty("cell.height"))*mnoz;
    float cell_Width =  Float.parseFloat(p.getProperty("cell.width"))*mnoz;


    private void systemMessage(String message){
       System.out.println(message);
    }

}