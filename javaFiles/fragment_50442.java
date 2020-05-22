IIOMetadata metadata = ...; 

IIOMetadataNode root = new IIOMetadataNode("javax_imageio_jpeg_image_1.0");
IIOMetadataNode markerSequence = new IIOMetadataNode("markerSequence");
root.appendChild(markerSequence);

Collection<Entry> entries = ...; // Your original Exif entries

// Write the full Exif segment data
ByteArrayOutputStream bytes = new ByteArrayOutputStream();
// APPn segments are prepended with a 0-terminated ASCII identifer
bytes.write("Exif".getBytes(StandardCharsets.US_ASCII));
bytes.write(new byte[2]); // Exif uses 0-termination + 0 pad for some reason
// Finally write the EXIF data
new EXIFWriter().write(entries, new MemoryCacheImageOutputStream(bytes));

// Wrap it all in a meta data node
IIOMetadataNode exif = new IIOMetadataNode("unknown");
exif.setAttribute("MarkerTag", String.valueOf(0xE1)); // APP1 or "225"
exif.setUserObject(bytes.toByteArray());

// Append Exif data 
markerSequence.appendChild(exif);

// Merge with original data 
metadata.mergeTree("javax_imageio_jpeg_image_1.0", root);