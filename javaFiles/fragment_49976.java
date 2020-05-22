PDDocument doc = new PDDocument();

PdfRenderingSimple renderer = new PdfRenderingSimple(doc);
for (int i = 0; i < 2000; i++)
{
    renderer.renderText("hello" + i, 60);
}
renderer.close();

doc.save(new File("renderSimple.pdf"));
doc.close();