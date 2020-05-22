package alpha;
public abstract class Alpha {
    final String alpha;
    Alpha() { this("A"); }
    public Alpha(String a) { alpha = a; }
}

package beta;

public class Beta extends alpha.Alpha {
    public Beta(String a) { super(a); }
}