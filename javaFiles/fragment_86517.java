public class TimeZoneComparator implements Comparator<TimeZone>
{
   private long date;

   public TimeZoneComparator(long date)
   {
      this.date = date;
   }

   public int compare(TimeZone tz1, TimeZone tz2)
   {
      return tz2.getOffset(this.date) - tz2.getOffset(this.date);
   }
}