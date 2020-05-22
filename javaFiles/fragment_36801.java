if (uniqueName) {
        PdfFormField parent = PdfFormField.createTextField(
                stamper.getWriter(), true, false, 0);
        parent.setFieldName(fieldName);
        parent.setUserName("Please enter the common demo data.");

        for (int page = 1; page <= pages; page++) {
            TextField textField = new TextField(stamper.getWriter(),
                    new Rectangle(560, 600, 590, 800), null);
            textField.setOptions(TextField.MULTILINE
                    | TextField.DO_NOT_SCROLL);
            textField.setRotation(90);
            PdfFormField pff = textField.getTextField();
            parent.addKid(pff);
            // add widget to each page
            pff.setPlaceInPage(page);
        }
        // add parent
        stamper.addAnnotation(parent, 1);
    } else {