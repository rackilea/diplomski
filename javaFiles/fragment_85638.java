public class ExampleClass {
    private final HashMap<String, URI> identifierAssociations = new HashMap<>();

    public MediaPlayer getPlayer(final String identifier) {
        final URI fileURI = identifierAssociations.get(identifier);
        final Media media = new Media(fileURI);
        return new MediaPlayer(media);
    }
}