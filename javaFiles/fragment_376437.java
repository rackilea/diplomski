public abstract class PeriodOfDays {
   int days;
   public PeriodOfDays(int days) { this.days = days; }
}

public class StandardYear extends PeriodOfDays {
   public StandardYear() { super(365); }
}

public class LeapYear extends PeriodOfDays {
   public LeapYear() { super(366); }
}