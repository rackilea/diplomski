public class ImageAdapter extends XmlAdapter<String, Image>{

    @Override
    public Image unmarshal(String data) throws Exception {
        return data == null || data.isEmpty() ? null : new Image(new ByteArrayInputStream(Base64.getDecoder().decode(data)));
    }

    @Override
    public String marshal(Image v) throws Exception {
        if (v == null) {
            return "";
        }
        BufferedImage bImg = SwingFXUtils.fromFXImage(v, null);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImg, "png", bos);

        return Base64.getEncoder().encodeToString(bos.toByteArray());
    }
}