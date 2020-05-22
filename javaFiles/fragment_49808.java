import java.nio.file.Path;
import javax.persistence.Convert;
import javax.persistence.Entity;

@Entity
public class Photo {

    @Convert(converter = PathConverter.class) // needed if autoApply isn't true
    private Path imagePath;

}