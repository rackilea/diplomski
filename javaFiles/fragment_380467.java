page = writer.getImportedPage(reader, i);
canvas.addTemplate(page, 1f, 0, 0, 1, 0, 0);
i++;
if (i <= reader.getNumberOfPages())
page = writer.getImportedPage(reader, i);
canvas.addTemplate(page, 1f, 0, 0, 1, width / 2, 0);
document.newPage();