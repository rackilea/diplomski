PDRectangle position = new PDRectangle();
    position.setLowerLeftX(10);
    position.setLowerLeftY(20); 
    position.setUpperRightX(100); 
    position.setUpperRightY(10); 
    txtLink.setRectangle(position);
    page.getAnnotations().add(txtLink);