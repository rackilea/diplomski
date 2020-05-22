private static void tikaMore(File file) {
    Tika defaultTika = new Tika();
    Tika mimeTika = new Tika(new MimeTypes());
    Tika typeTika = new Tika(new TypeDetector());
    try {
        System.out.println(defaultTika.detect(file));
        System.out.println(mimeTika.detect(file));
        System.out.println(typeTika.detect(file));
    } catch (Exception e) {
        // TODO: handle exception
    }
}