public void cellLayout(PdfPCell cell, Rectangle rectangle,
                PdfContentByte[] canvases) {
            final PdfWriter writer = canvases[0].getPdfWriter();
            final TextField textField = new TextField(writer, rectangle,
                    fieldname);
            textField.setText(textField.getFieldName());
            try {
                final PdfFormField field = textField.getTextField();
                writer.addAnnotation(field);
            } catch (final IOException ioe) {
                throw new ExceptionConverter(ioe);
            } catch (final DocumentException de) {
                throw new ExceptionConverter(de);
            }
        }