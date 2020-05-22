public class Main
{
  public static void main (String[]args)
  {
    Worker bob = new Worker ();
      System.out.println (bob.getHours ());
  }

  static public class Worker
  {
    private int hours;
    private double rate;
    public Worker ()
    {
      hours = 999;
      rate = 999;
    }
    public Worker (int nHours, double nRate)
    {
      hours = nHours;
      rate = nRate;
    }
    public int getHours ()
    {
      return hours;
    }
    public void setHours (int nHours)
    {
      hours = nHours;
    }
    public double getRate ()
    {
      return rate;
    }
    public void setRate (double nRate)
    {
      rate = nRate;
    }
    public double paycheck ()
    {
      return rate * hours;
    }
    public void raise (double raise)
    {
      rate = raise + rate;
    }

  }

}