Image image;

ImageDescriptor[] descriptors = new ImageDescriptor[5]

descriptors[IDecoration.BOTTOM_LEFT] = ... overlay image descriptor

Image decorated = new DecorationOverlayIcon(image, descriptors).createImage();