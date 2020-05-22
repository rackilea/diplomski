import javafx.scene.image.Image;
import javafx.util.Builder;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

public class ImageButtonBuilder extends AbstractMap<String, Object> implements Builder<ImageButton> {

    private String text = "";
    private Image image;

    private ImageButtonBuilder() {}

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return new HashSet<>();
    }

    public static ImageButtonBuilder create() {
        return new ImageButtonBuilder();
    }

    @Override
    public Object put(String key, Object value) {
        if (value != null) {
            String str = value.toString();

            if ("image".equals(key)) {
                image = (Image) value;
            } else if ("text".equals(key)) {
                text = str;
            } else {
                throw new IllegalArgumentException("Unknown property: " + key);
            }
        }

        return null;
    }

    @Override
    public ImageButton build() {
        return new ImageButton(image, text);
    }

}