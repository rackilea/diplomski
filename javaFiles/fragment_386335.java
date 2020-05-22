public class Catalogue 
{
    private Mammal mammal;
    private Bird[] birds;
    public Catalogue(Mammal mammal, Bird[] birds)
    {
       this.mammal = mammal;
       this.birds = birds;
    }
    public Mammal getMammal()
    {
     return mammal;
    }
    public Bird[] getBirds()
    {
      return birds;
    }
}