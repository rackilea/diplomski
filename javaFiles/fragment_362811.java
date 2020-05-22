public class Loan {

  private static HashMap<Integer,Double> rate = new HashMap<Integer,Double>();

  Loan()
  {
    //I would recommend populating the rate HashMap
    //in the constructor so it isn't populated
    //every time you call getRate
    rate.put(15, 3.25);
    rate.put(30, 3.95);
  }

  public double getRate(int year) {
    //Now you can just the desired rate
    return rate.get(year);
  }
}