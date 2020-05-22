PdfReader reader = new PdfReader(src);
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
AcroFields form = stamper.getAcroFields();
form.setField(key, value);
stamper.setFormFlattening(true);
stamper.close();
reader.close();