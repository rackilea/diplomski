public class Cars extends Audi{ //extending Audi.

  private String model;
  private String name;
  private int year;

  Cars(int year, String model, String name)
  {
    this.year = year;
    this.model = model;
    this.name = name;
  }

  public String getName() { return name; }    

  public String getModel() { return model; }

  public int getYear() { return year; }

}