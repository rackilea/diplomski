PdfReader reader = new PdfReader(src);
// We assume that there's a single large picture on the first page
PdfDictionary page = reader.getPageN(1);
PdfDictionary resources = page.getAsDict(PdfName.RESOURCES);
PdfDictionary xobjects = resources.getAsDict(PdfName.XOBJECT);
PdfName imgName = xobjects.getKeys().iterator().next();
Image img = Image.getInstance((PRIndirectReference)xobjects.getAsIndirectObject(imgName));
img.setAbsolutePosition(0, 0);
img.scaleAbsolute(reader.getPageSize(1));
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
stamper.getOverContent(1).addImage(img);
stamper.close();
reader.close();