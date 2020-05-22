try (InputStream is = new BufferedInputStream(
    Files.newInputStream(Paths.get("C:/Users/Prak01/Documents/EclipseWorkspace/Zeiterfassung/fontawesome-webfont.ttf")))) {

    // ...

} catch (FontFormatException e1) {
    // ...
}