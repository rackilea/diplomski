PDRectangle position = new PDRectangle();
position.setUpperRightX(textPosition.getX());
position.setUpperRightY(ph - textPosition.getY());

position.setLowerLeftX(textPosition.getX()-4);
position.setLowerLeftY(ph - textPosition.getY());
PDGamma colourBlue = new PDGamma();
colourBlue.setB(1);

PDAnnotationText text = new PDAnnotationText();
text.setContents(commentNameWithComments.get(word));
text.setRectangle(position);
text.setOpen(true);
text.setConstantOpacity(50f);

assert annotations != null;
annotations.add(text);
page1.setAnnotations(annotations);
replaceText(word);