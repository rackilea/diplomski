public class RpgPersonExample
{
   public static void main( String[] args )
   {
      Map<String, RpgPerson> team = new HashMap<>();
      team.put( "Sgt. Mayhem", new RpgPerson( 100, 10, 0 ) );
      team.put( "Wizard", new RpgPerson( 100, 1, 10 ) );
      team.put( "Dragon", new RpgPerson( 1000, 100, 100 ) );

      System.out.println( team.get( "Dragon" ) );
      System.out.println( team.get( "Wizard" ) );
   }

}

class RpgPerson
{

   private int hits;
   private int strength;
   private int magic;

   public RpgPerson( int hits, int strength, int magic )
   {
      this.hits = hits;
      this.strength = strength;
      this.magic = magic;
   }

   @Override
   public String toString()
   {
      return "RpgPerson{" + "hits=" + hits + ", strength=" +
              strength + ", magic=" + magic + '}';
   }

}