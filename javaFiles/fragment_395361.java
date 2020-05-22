public class Engine {


    ArrayList<Color> arr = new ArrayList<Color>();
    private int xx;
    private int yy;
    FileOutputStream out;
    HSSFSheet sheet;
    HSSFWorkbook wb;
    Row r;

    public void process() throws AWTException, IOException{

        wb = new HSSFWorkbook();
        sheet = wb.createSheet();
        wb.setActiveSheet(0);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/images.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("img file not found");
        }


                  for(int x=0;x<img.getWidth();x++){
                     xx++;
                     yy=0;
                      r = sheet.createRow(xx);
                  for(int y=0;y<img.getHeight();y++){
                     yy++;
                    int rgb = img.getRGB(x, y);
                    Color c = new Color(rgb);
                    printPixelARGB(rgb);
                    arr.add(c);

                    System.out.println("x: "+ x + " y:" + y +" color: " + c);


                 }}
                  out = new FileOutputStream("pic.xls");
                  wb.write(out);
                  out.close();
               }

             public void printPixelARGB(int pixel)  {
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                    Cell c = r.createCell(yy);
                    HSSFCellStyle style = wb.createCellStyle();
                    HSSFColor col = setColor(wb, (byte)red, (byte)green,(byte)blue);
                    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                    style.setFillForegroundColor(col.getIndex());
                    c.setCellStyle(style);

              }

             public HSSFColor setColor(HSSFWorkbook workbook, byte r,byte g, byte b){
                 HSSFPalette palette = workbook.getCustomPalette();
                 HSSFColor hssfColor = null;
                 try {
                 hssfColor= palette.findSimilarColor(r, g, b); 
                 if (hssfColor == null ){
                     palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g,b);
                     hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
                 }
                  } catch (Exception e) {
                 System.out.println("error");
                 }

                  return hssfColor;
                 }

}