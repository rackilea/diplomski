public class DatedValue {
  private final Date date;
  private final BigDecimal value;

  public DatedValue(final Date date, final BigDecimal value) {
    this.date = date;
    this.value = value;
  }

  public Date getDate() {
    return date;
  }

  public BigDecimal getValue() {
    return value;
  }
}