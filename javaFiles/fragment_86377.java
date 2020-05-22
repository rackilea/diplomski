Display d = Display.getDefault();
Image image = new Image(d, "/pictures/Llama.gif");

ImageLoader saver = new ImageLoader();
saver.data = new ImageData[] { image.getImageData() };
saver.save("output.png", SWT.IMAGE_PNG);

image.dispose();