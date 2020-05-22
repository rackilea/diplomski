public class LoadImageCommand extends AbstractCommand<Image> {

    public LoadImageCommand() {
        this(null);
    }

    public LoadImageCommand(Window window) {
        super(window);
    }

    @Override
    public Optional<Image> execute() {
        Image image = null;

        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(getWindow());
        try {
            if(file != null) {
                BufferedImage bufferedImage = ImageIO.read(file);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
            }
        } catch (IOException e) {
            System.out.println("lol");
        }

        return Optional.ofNullable(image);
    }
}