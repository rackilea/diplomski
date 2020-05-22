page = writer.getImportedPage(reader, i);
canvas.addTemplate(page, 1f, 0, 0, 1, 0, height / 2);
i++;
if (i <= reader.getNumberOfPages())
page = writer.getImportedPage(reader, i);
canvas.addTemplate(page, 1f, 0, 0, 1, 0, 0);
document.newPage();