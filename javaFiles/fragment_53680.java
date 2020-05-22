// Beware 5400x2700 px image 2MB
Image image = new Image("http://eoimages.gsfc.nasa.gov/images/imagerecords/73000/73751/world.topo.bathy.200407.3x5400x2700.jpg", true);
ImageView imageView = new ImageView(image);
ScrollPane root = new ScrollPane(imageView);
root.setPannable(true);

Scene scene = new Scene(root, 300, 300);