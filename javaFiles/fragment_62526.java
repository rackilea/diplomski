public class MyPageEventListener extends PdfPageEventHelper {
  . . .
  @Override
  public void onEndPage(PdfWriter writer, Document document) {
     //code skeleton to write page header
     PdfPTable tbl = new PdfPTable(3);
     tbl.addCell("1st cell");
     tbl.addCell("2nd cell");
     tbl.addCell("3rd cell");
     float x = document.leftMargin();
     float hei = getMyHeaderHeight(); //custom method that return header's height 
     //align bottom between page edge and page margin
     float y = document.top() + hei;

     //write the table
     tbl.writeSelectedRows(0, -1, x, y, writer.getDirectContent());
  }    
}