public class RequireCharacters implements Comparable<RequireCharacters> {
   public final long required;
   public final CountDownLatch latch = new CountDownLatch(1);

   /* ctor etc. */

   public int compareTo(RequireCharacters other) { return Long.compare(this.required, other.required); }
}