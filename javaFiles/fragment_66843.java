ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next();
writer.setOutput(stream);

IIOMetadata streamMetadata = writer.getDefaultStreamMetadata();

IIOMetadataNode root = new IIOMetadataNode("com_sun_media_imageio_plugins_tiff_stream_1.0");
IIOMetadataNode byteOrder = new IIOMetadataNode("ByteOrder");
byteOrder.setAttribute("value", order == LITTLE_ENDIAN ? "LITTLE_ENDIAN" : "BIG_ENDIAN");
root.appendChild(byteOrder);

streamMetadata .mergeTree("com_sun_media_imageio_plugins_tiff_stream_1.0", root);

// ...

writer.write(streamMetadata, new IIOImage(image, null, null), param);