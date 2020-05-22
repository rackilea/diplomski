public class PNGICCProfileIssue {
    public static void main(String[] args) throws IOException {
        File input = new File(args[0]);
        BufferedImage image = ImageIO.read(input);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("PNG");
        if (!writers.hasNext()) {
            return;
        }

        ImageWriter writer = writers.next();
        writer.setOutput(ImageIO.createImageOutputStream(new File(input.getParent(), input.getName().replace('.', '_') + "_icc.png")));

        IIOMetadata imageMetadata = writer.getDefaultImageMetadata(ImageTypeSpecifier.createFromRenderedImage(image), writer.getDefaultWriteParam());

        //add ICC PROFILE
        IIOMetadataNode iccp = new IIOMetadataNode("iCCP");
        ICC_ColorSpace colorSpace = (ICC_ColorSpace) ColorSpaces.getColorSpace(ColorSpaces.CS_ADOBE_RGB_1998);
        iccp.setUserObject(getAsDeflatedBytes(colorSpace));
        iccp.setAttribute("profileName", "AdobeRGB1998");
        iccp.setAttribute("compressionMethod", "deflate");

        Node nativeTree = imageMetadata.getAsTree(imageMetadata.getNativeMetadataFormatName());
        nativeTree.appendChild(iccp);
        imageMetadata.mergeTree(imageMetadata.getNativeMetadataFormatName(), nativeTree);

        writer.write(new IIOImage(image, null, imageMetadata));
    }

    private static byte[] getAsDeflatedBytes(ICC_ColorSpace colorSpace) throws IOException {
        byte[] data = colorSpace.getProfile().getData();

        ByteArrayOutputStream deflated = new ByteArrayOutputStream();
        DeflaterOutputStream deflater = new DeflaterOutputStream(deflated);
        deflater.write(data);
        deflater.flush();
        deflater.close();

        return deflated.toByteArray();
    }