import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class ImageButtonBuilderFactory implements BuilderFactory {

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == null) {
            throw new NullPointerException();
        }
        if (type == ImageButton.class) {
            return ImageButtonBuilder.create();
        }
        return null;
    }
}