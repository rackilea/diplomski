FieldGroup fieldGroup = new FieldGroup(item);
    fieldGroup.setFieldFactory(new ImageEnhancedFieldFactory(new Property.ValueChangeListener() {
        @Override
        public void valueChange(Property.ValueChangeEvent event) {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String filename = "myfilename-" + df.format(new Date()) + ".jpg";
            imagePojo.setImageContent((byte[])event.getProperty().getValue());
            image.markAsDirty();
            imageResource.setFilename(filename);
        }
    }));

    addComponent(fieldGroup.buildAndBind("Image name", "name"));
    addComponent(fieldGroup.buildAndBind("Image content", "imageContent"));