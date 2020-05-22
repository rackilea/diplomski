boolean b = true;
for(PdfPRow r: table.getRows()) {
  for(PdfPCell c: r.getCells()) {
    c.setBackgroundColor(b ? BaseColor.GREY : BaseColor.WHITE);
  }
  b = !b;
}