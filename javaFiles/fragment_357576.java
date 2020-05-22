public class World
{
  private Country[] countries;
  private int numCountries;

  public World()
  {
    this.countries = new Country[16];       // allocate the array
    this.numCountries = 0;
  }

  ...
}