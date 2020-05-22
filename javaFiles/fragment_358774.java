File myFile1 = new File("/sdcard/ourdata/" + pdfname + ".pdf");
myFile1.createNewFile();
Document pdfDoc = new Document();
PdfWriter docWriter = PdfWriter.getInstance(document,
        new FileOutputStream(myFile1));
document.open();
PdfContentByte cb = docWriter.getDirectContent();
InputStream inputStream = getAssets().open("signature.png");
Bitmap bmp = BitmapFactory.decodeStream(inputStream);
ByteArrayOutputStream stream = new ByteArrayOutputStream();
bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
Image signature = Image.getInstance(stream.toByteArray());
signature.setAbsolutePosition(400f, 150f);
signature.scalePercent(25f);
document.add(signature);