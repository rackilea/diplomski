public class MbcPoc {

    public static void main(String... args) throws NotFoundException, IOException {
        List<BarcodeInfo> list = decodeImageWithMBC("fREyt.png");
        list.forEach(BarcodeInfo::println);
    }

    private static List<BarcodeInfo> decodeImageWithMBC(String imgPath) throws NotFoundException, IOException {
        BufferedImage img = ImageIO.read(new File(imgPath));
        BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(img)));
        MultipleBarcodeReader mbReader = new GenericMultipleBarcodeReader(new MultiFormatReader());
        Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        List<BarcodeInfo> list = new ArrayList<>();
        for (Result result : mbReader.decodeMultiple(bb, hints)) {
            list.add(new BarcodeInfo(result.getText(), result.getBarcodeFormat().name()));
        }
        return list;
    }

    public static class BarcodeInfo {
        private final String text;
        private final String format;

        BarcodeInfo(String text, String format) {
            this.text = text;
            this.format = format;
        }

        public static void println(BarcodeInfo bci) {
            System.out.println(bci.text + "/" + bci.format);
        }
    }
}