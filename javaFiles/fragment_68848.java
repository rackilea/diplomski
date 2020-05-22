public static PdfReader unlockPdf(PdfReader reader) {
    if (reader == null) {
        return reader;
    }
    try {
        java.lang.reflect.Field f = reader.getClass().getDeclaredField("encrypted");
        f.setAccessible(true);
        f.set(reader, false);
    } catch (Exception e) { /* ignore */ }
    return reader;
}