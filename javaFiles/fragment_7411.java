public class Sprite {

    private BufferedImage source;
    private int imageCount;
    private int imageWidth;

    // How long it takes to play a full cycle
    private Duration duration;
    // When the last cycle was started
    private Instant startedAt;

    public Sprite(BufferedImage source, int imageCount, int cycleTimeInSeconds) throws IOException {
        this.source = source;
        this.imageCount = imageCount;
        imageWidth = source.getWidth() / imageCount;
        duration = Duration.ofSeconds(cycleTimeInSeconds);
    }

    public BufferedImage getFrame() {
        if (startedAt == null) {
            startedAt = Instant.now();
        }
        Duration timePlayed = Duration.between(startedAt, Instant.now());
        double progress = timePlayed.toMillis() / (double)duration.toMillis();
        if (progress > 1.0) {
            progress = 1.0;
            startedAt = Instant.now();
        }
        int frame = Math.min((int)(imageCount * progress), imageCount - 1);
        return getImageAt(frame);
    }

    protected BufferedImage getImageAt(int index) {
        if (index < 0 || index >= imageCount) {
            return null;
        }
        int xOffset = imageWidth * index;
        return source.getSubimage(xOffset, 0, imageWidth, source.getHeight());
    }

}