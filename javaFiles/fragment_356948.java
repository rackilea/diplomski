contentStream.beginText();
contentStream.setNonStrokingColor(0,0,0);
contentStream.setFont(PDType1Font.TIMES_ROMAN, 8);
contentStream.newLineAtOffset(50,220);
contentStream.showText("Website: google.com");
contentStream.endText();

// create a link annotation
PDAnnotationLink txtLink = new PDAnnotationLink();

// add an underline
PDBorderStyleDictionary underline = new PDBorderStyleDictionary();
underline.setStyle(PDBorderStyleDictionary.STYLE_UNDERLINE);
txtLink.setBorderStyle(underline);

PDRectangle position = new PDRectangle();
position.setLowerLeftX(75);
position.setLowerLeftY(210);
position.setUpperRightX(85);
position.setUpperRightY(220);
txtLink.setRectangle(position);

PDActionURI action = new PDActionURI();
action.setURI("http://www.Google.com");
txtLink.setAction(action);

page.getAnnotations().add(txtLink);