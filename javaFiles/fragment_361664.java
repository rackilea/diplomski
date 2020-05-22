ByteArrayOutputStream out = new ByteArrayOutputStream();
// creating / modifying the pdf
...
byte[] pdfoutput = out.toByteArray();
res.setContentLength(pdfoutput.length);
res.getOutputStream().write(pdfoutput);