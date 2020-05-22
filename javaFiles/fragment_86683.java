import java.util.Arrays;
import java.util.List;

public class Path {
    private final List<Segment> segments;

    public Path(Segment... segs) {
        this.segments = Arrays.asList(segs);
    }
}