// Obtain qtables
mQMatrix = ...;

// Read source image
ImageInputStream imageInputStream = ImageIO.createImageInputStream(...);
ImageReader reader = ImageIO.getImageReaders(imageInputStream).next();
reader.setInput(imageInputStream);

mSourceImage = reader.read(0);
IIOMetadata metadata = null;

// We need the imageWriter to create the default JPEG metadata
ImageWriter imageWriter = ImageIO.getImageWritersByFormatName("JPEG").next();

if (mQMatrix != null) {
    dumpMatrices(mQMatrix);

    // Obtain default image metadata data, in native JPEG format
    metadata = imageWriter.getDefaultImageMetadata(ImageTypeSpecifier.createFromRenderedImage(m‌​SourceImage), null);
    IIOMetadataNode nativeMeta = (IIOMetadataNode) metadata.getAsTree("javax_imageio_jpeg_image_1.0");

    // Update dqt to values from mQMatrix
    NodeList dqtables = nativeMeta.getElementsByTagName("dqtable");
    for (int i = 0; i < dqtables.getLength(); i++) {
        IIOMetadataNode dqt = (IIOMetadataNode) dqtables.item(i);
        int dqtId = Integer.parseInt(dqt.getAttribute("qtableId"));
        dqt.setUserObject(mQMatrix[dqtId]);
    }

    // For some reason, we need dht explicitly defined, when using MODE_COPY_FROM_METADATA...
    NodeList dhtables = nativeMeta.getElementsByTagName("dhtable");

    // Just use defaults for dht
    JPEGHuffmanTable[] huffmanDcTables = {JPEGHuffmanTable.StdDCLuminance, JPEGHuffmanTable.StdDCChrominance};
    JPEGHuffmanTable[] huffmanAcTables = {JPEGHuffmanTable.StdACLuminance, JPEGHuffmanTable.StdACChrominance};

    // Update dht
    for (int i = 0; i < dhtables.getLength(); i++) {
        IIOMetadataNode dht = (IIOMetadataNode) dhtables.item(i);
        int dhtClass = Integer.parseInt(dht.getAttribute("class")); // 0: DC, 1: AC
        int dhtId = Integer.parseInt(dht.getAttribute("htableId"));

        dht.setUserObject(dhtClass == 0 ? huffmanDcTables[dhtId] : huffmanAcTables[dhtId]);
    }

    // Merge updated tree back (important!)
    metadata.mergeTree("javax_imageio_jpeg_image_1.0", nativeMeta);
}

ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
imageWriter.setOutput(imageOutputStream);

// See http://docs.oracle.com/javase/6/docs/api/javax/imageio/metadata/doc-files/jpeg_metadata.html#tables
JPEGImageWriteParam params = new JPEGImageWriteParam(null);
params.setCompressionMode(metadata == null ? MODE_DEFAULT : MODE_COPY_FROM_METADATA); // Unless MODE_COPY_FROM_METADATA, tables will be created!

imageWriter.write(null, new IIOImage(mSourceImage, null, metadata), params);
imageOutputStream.close();

mCompressedImageSize = outputStream.size();

try (FileOutputStream fileOutputStream = new FileOutputStream(mOutFileName)) {
    fileOutputStream.write(outputStream.toByteArray());
}

mCompressedImage = ImageIO.read(new ByteArrayInputStream(outputStream.toByteArray()));