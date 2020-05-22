try (BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(
        new FileOutputStream("out.txt"), "UTF-8"));) {

    objects.forEach((o) -> {
        try {
            bw.write(o.toString()));
        } catch(IOException kludgy) {
            throw new UncheckedIOException(kludgy);
        }
    });

} catch (UncheckedIOException kludgy) {
    IOException cause = kludgy.getCause();
    // handle exception
}