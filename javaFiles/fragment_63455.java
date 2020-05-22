String imageString = request.getParameter("SignatureImage");
byte[] decodedBytes = Base64.decode(imageString, Base64.DEFAULT);

try {
    InputStream in = new ByteArrayInputStream(decodedBytes);
    BufferedImage bImageFromConvert = ImageIO.read(in);

    ImageIO.write(bImageFromConvert, "png", new File(
            "E:/signature/signature.png"));
} catch (IOException e) {
    e.printStackTrace();
}