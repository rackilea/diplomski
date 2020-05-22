PDDocument document = new PDDocument();
InputStream in = new FileInputStream(someImage);
BufferedImage bimg = ImageIO.read(in);
float width = bimg.getWidth();
float height = bimg.getHeight();
PDPage page = new PDPage(new PDRectangle(width, height));
document.addPage(page); 
PDXObjectImage img = new PDJpeg(document, new FileInputStream(someImage));
PDPageContentStream contentStream = new PDPageContentStream(document, page);
contentStream.drawImage(img, 0, 0);
contentStream.close();
in.close();

document.save("test.pdf");
document.close();