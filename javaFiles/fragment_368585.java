PdfPCell cell;

for(int i = 0;i< 25;i++)
{

    if(locs.get(i) != null)
    {
        Font font = new Font(FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);


        cell = new PdfPCell(new Phrase(locs.get(i), font));
        cell.setRotation(90);
        cell.setBorder(0);                                              
        cell.setFixedHeight(110f);
        cell.setColspan(2);               
        table.addCell(cell);
   }
    else
    {
        cell = new PdfPCell();
        cell.setBorder(0);
        table.addCell(cell);
    }
}