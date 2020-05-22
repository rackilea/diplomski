PdfReader reader = new PdfReader(src); 
AcroFields acroFields = reader.getAcroFields(); 
acroFields.removeField("my_signature_name"); 
PdfStamper stamper = new PdfStamper(reader, dest); 
stamper.close(); 
reader.close();