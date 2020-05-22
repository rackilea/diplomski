PdfFormField field = fields.get("QRCODE");
// Get the annotation. If you might have multiple representations of the same field across the document the just iterate over all widgets
PdfWidgetAnnotation annotation = field.getWidgets().get(0);
// This class will help us draw the barcode
BarcodeQRCode qrCode = new BarcodeQRCode(this.generateXMLDataMatrix());
// Get the number of rectangles constituting the barcode
Rectangle size = qrCode.getBarcodeSize();
// Creating a new FormXObject that will become our apperance. Set the dimension(bbox) of the current appearance
PdfFormXObject newAppearance = new PdfFormXObject(annotation.getAppearanceObject(PdfName.N).getAsRectangle(PdfName.BBox));
// Helper class to draw on FormXObject
PdfCanvas barcodeCanvas = new PdfCanvas(newAppearance, pdfDocument);
// Calculating the side of the smaller rectangle in the barcode
float side = Math.min(annotation.getRectangle().toRectangle().getHeight() / size.getHeight(),
        annotation.getRectangle().toRectangle().getWidth() / size.getWidth());
// Draw the barcode on the XObject
qrCode.placeBarcode(barcodeCanvas, ColorConstants.BLACK, side);
// Set appearance to the newly generated one
annotation.setAppearance(PdfName.N, newAppearance.getPdfObject());