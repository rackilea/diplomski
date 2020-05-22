AcroFields form = stamper.getAcroFields();
AcroFields.Item item;
item = form.getFieldItem("fieldLeft");
item.getMerged(0).put(PdfName.Q, new PdfNumber(PdfFormField.Q_LEFT));
item = form.getFieldItem("fieldCenter");
item.getMerged(0).put(PdfName.Q, new PdfNumber(PdfFormField.Q_CENTER));
item = form.getFieldItem("fieldRight");
item.getMerged(0).put(PdfName.Q, new PdfNumber(PdfFormField.Q_RIGHT));