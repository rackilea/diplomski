package somemodule;

import java.util.function.Supplier;

public interface ImageType {
    String name();
    interface ImageTypes extends Supplier<ImageType[]> {}
}