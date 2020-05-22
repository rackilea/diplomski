Image image = Image.getInstance(IMG);
image.scaleAbsolute(12, 12);
image.setScaleToFitHeight(false);
List list = new List();
list.setListSymbol(new Chunk(Image.getInstance(image), 0, 0));
list.add("Hello World");
list.add("This is a list item with a lot of text. It will certainly take more than one line. This shows that the list item is indented and that the image is used as bullet.");
list.add("This is a test");
document.add(list);