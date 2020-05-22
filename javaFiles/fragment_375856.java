public class Coordinate
{
    public final int x;
    public final int y;

    public Coordinate(@Nonnull final int x, @Nonnul final int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString() { return String.format("%d/%d", this.x, this.y); }

    public int hashCode() { return this.toString().hashCode(); }

    public boolean equals(@Nullable final Object o) { return this.equals((Coordinate)o); }

    public boolean equals(@Nullable final Coordinate c) { return this.x = c.x && this.y == c.y; }
}