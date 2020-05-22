public class AnnotatedPoint implements Comparable<AnnotatedPoint> {
    public int value;
    public PointType type;

    public AnnotatedPoint(int value, PointType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public int compareTo(AnnotatedPoint other) {
        if (other.value == this.value) {
            return this.type.ordinal() < other.type.ordinal() ? -1 : 1;
        } else {
            return this.value < other.value ? -1 : 1;
        }
    }

    // the order is important here: if multiple events happen at the same point,
    // this is the order in which you want to deal with them
    public enum PointType {
        End, GapEnd, GapStart, Start
    }
}