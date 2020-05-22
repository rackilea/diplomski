PdfReader reader = new PdfReader(pathToCertificateTemplate);
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathToCertificate));
AcroFields form = stamper.getAcroFields();
form.setField("name", name);
form.setField("course", course);
form.setField("date", date);
stamper.setFormFlattening(true);
stamper.close();
reader.close();