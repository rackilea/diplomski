...

import java.awt.Desktop; // importing more classes from awt than neccessary could result in problems
...

public class DischargeComment extends ListCell<Comment> {

    ...

    /**
     * Constructor to pass external cache
     * @param cache 
     */
    public DischargeComment(Map<String, SoftReference<Image>> cache) {
        if (cache == null) {
            throw new IllegalArgumentException();
        }
        this.cache = cache;
    }

    /**
     * constructor using the default cache
     */
    public DischargeComment() {
        this(getDefaultCache());
    }

    private final Map<String, SoftReference<Image>> cache;

    private static Map<String, SoftReference<Image>> defaultCache;

    private static final URL FXML_URL = DischargeComment.class.getResource("cell/discharge_comment.fxml");

    public static Map<String, SoftReference<Image>> getDefaultCache() {
        if (defaultCache == null) {
            defaultCache = new HashMap<>();
        }
        return defaultCache;
    }

    public static String search = "";
    private boolean loaded = false; // no need for a reference to fxmlloader here

    @Override
    protected void updateItem(Comment item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (!loaded) {
                FXMLLoader mLLoader = new FXMLLoader(FXML_URL);
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                    img.setClip(new Circle(25, 25, 25));
                    loaded = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            ...

            // use single access here
            // also use url as key
            cache.compute(item.getOwnerProfilePicUrl(), (key, value) -> {
                Image image = null;
                if (value != null) {
                    image = value.get();
                }
                if (image == null) {
                    image = new Image(key, true); // load image in background
                    value = new SoftReference<>(image);
                }
                img.setImage(image);
                return value;
            });

            lblUsername.setOnMouseClicked(e->{
                try {
                    Desktop.getDesktop().browse(new URI("https://www.instagram.com/" + item.getOwnerUsername()));
                } catch (IOException | URISyntaxException exception) {
                    exception.printStackTrace();
                }
            });

            setText(null);
            setGraphic(pane);
            setPrefHeight(Region.USE_COMPUTED_SIZE); // don't set height to -1
        }
    }
}