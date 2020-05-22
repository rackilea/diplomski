void writeAnimatedGif(OutputStream stream,
                      Iterable<BufferedImage> frames,
                      int delayInMilliseconds,
                      Integer repeatCount)
throws IOException {
    try (ImageOutputStream iioStream =
            ImageIO.createImageOutputStream(stream)) {

        ImageWriter writer =
            ImageIO.getImageWritersByMIMEType("image/gif").next();
        writer.setOutput(iioStream);

        writer.prepareWriteSequence(null);

        for (BufferedImage frame : frames) {
            writeFrame(frame, delayInMilliseconds, writer, repeatCount);
            repeatCount = null;
        }

        writer.endWriteSequence();
        writer.dispose();
    }
}

void writeFrame(BufferedImage image,
                int delayInMilliseconds,
                ImageWriter writer,
                Integer repeatCount)
throws IOException {
    ImageTypeSpecifier type =
        ImageTypeSpecifier.createFromRenderedImage(image);
    IIOMetadata metadata = writer.getDefaultImageMetadata(type, null);
    String format = metadata.getNativeMetadataFormatName();

    Node tree = metadata.getAsTree(format);

    if (repeatCount != null)
    {
        setRepeatCount(repeatCount, tree);
    }

    setDelayTime(delayInMilliseconds, tree);

    metadata.setFromTree(format, tree);

    writer.writeToSequence(new IIOImage(image, null, metadata), null);
}

private void setRepeatCount(Number repeatCount, Node imageMetadata)
{
    Element root = (Element) imageMetadata;

    ByteBuffer buf = ByteBuffer.allocate(3).order(ByteOrder.LITTLE_ENDIAN);
    buf.put((byte) 1);  // sub-block index (always 1)
    byte[] appExtBytes = buf.putShort(repeatCount.shortValue()).array();

    Element appExtContainer;
    NodeList nodes = root.getElementsByTagName("ApplicationExtensions");
    if (nodes.getLength() > 0) {
        appExtContainer = (Element) nodes.item(0);
    } else {
        appExtContainer = new IIOMetadataNode("ApplicationExtensions");

        Node reference = null;
        nodes = root.getElementsByTagName("CommentExtensions");
        if (nodes.getLength() > 0) {
            reference = nodes.item(0);
        }

        root.insertBefore(appExtContainer, reference);
    }

    IIOMetadataNode appExt =
        new IIOMetadataNode("ApplicationExtension");
    appExt.setAttribute("applicationID", "NETSCAPE");
    appExt.setAttribute("authenticationCode", "2.0");
    appExt.setUserObject(appExtBytes);

    appExtContainer.appendChild(appExt);
}


private void setDelayTime(int delayInMilliseconds, Node imageMetadata)
{
    Element root = (Element) imageMetadata;

    Element gce;
    NodeList nodes = root.getElementsByTagName("GraphicControlExtension");
    if (nodes.getLength() > 0) {
        gce = (Element) nodes.item(0);
    } else {
        gce = new IIOMetadataNode("GraphicControlExtension");

        Node reference = null;
        nodes = root.getElementsByTagName("PlainTextExtension");
        if (nodes.getLength() > 0) {
            reference = nodes.item(0);
        }
        if (reference == null) {
            nodes = root.getElementsByTagName("ApplicationExtensions");
            if (nodes.getLength() > 0) {
                reference = nodes.item(0);
            }
        }
        if (reference == null) {
            nodes = root.getElementsByTagName("CommentExtensions");
            if (nodes.getLength() > 0) {
                reference = nodes.item(0);
            }
        }

        root.insertBefore(gce, reference);
    }

    gce.setAttribute("delayTime",
        String.valueOf(delayInMilliseconds / 10));
}