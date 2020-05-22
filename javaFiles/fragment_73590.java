...
import java.util.Objects;

public class Music {
    ...

    @Override
    public boolean equals(Object obj) {
        // make sure equals is symetric
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Music other = (Music) obj;
        // compare strings for equality
        return Objects.equals(this.getAlbum(), other.getAlbum())
                && Objects.equals(this.getSong(), other.getSong())
                && Objects.equals(this.getGenre(), other.getGenre());
    }

}