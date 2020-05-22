PdfTemplate template = writer.getDirectContent().createTemplate(120, 80);
template.setColorFill(BaseColor.RED);
template.rectangle(0, 0, 120, 80);
template.fill();
writer.releaseTemplate(template);
table.addCell(Image.getInstance(template));