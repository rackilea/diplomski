// Start out with the original tree
IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree("javax_imageio_jpeg_image_1.0");
IIOMetadataNode markerSequence = (IIOMetadataNode) root.getElementsByTagName("markerSequence").item(0); // Should always a single markerSequence

...

// Remove any existing Exif, or make sure you update the node, 
// to avoid having two Exif nodes
// Logic for creating the node as above

...

// Replace the tree, instead of merging
metadata.setFromTree("javax_imageio_jpeg_image_1.0", root);