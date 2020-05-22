public class CustomerPhoneNumber
{
  private String npa; // numbering plan area (google search nanp for more details)
  private String nxx; // exchange.
  private String serviceNumber;

  public String toString()
  {
    return "(" + npa + ") " + nxx + "-" + serviceNumber;
  }

  public boolean equals(Object object)
  {
    ... standard equals implementation (assume this works)
  }
}