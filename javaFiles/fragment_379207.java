/**
 * Returns the active screen resolution. If Batik is run in a headless environment, this
 * method will return the default "96" unlike {@link Toolkit#getScreenResolution()} which
 * will throw a {@link HeadlessException}.
 * @return the screen resolution in dpi
 */
public static int getScreenResolution() {
    if (GraphicsEnvironment.isHeadless()) {
        return 96;
    } else {
        return Toolkit.getDefaultToolkit().getScreenResolution();
    }
}