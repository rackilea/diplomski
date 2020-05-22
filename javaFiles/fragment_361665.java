DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
Document doc = builder.parse(new StringBufferInputStream(buf.toString())); 

OutputStream os = new ByteArrayOutputStream(); 
ITextRenderer renderer = new ITextRenderer(); 
renderer.setDocument(doc, null); 
renderer.layout(); 
renderer.createPDF(os); 
os.close(); 

PdfReader reader = new PdfReader(((ByteArrayOutputStream)os).toByteArray()); 
OutputStream out = new ByteArrayOutputStream(); 
PdfStamper stamper = new PdfStamper(reader, out); 
stamper.setPageAction(PdfWriter.PAGE_OPEN, new PdfAction(PdfAction.PRINTDIALOG), 1); 
stamper.close(); 

resp.getOutputStream().write(((ByteArrayOutputStream)out).toByteArray());