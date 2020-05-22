public class Combat
{
   private Hero hero;

   //setter
   public void setHero(Hero hero1)
   {
      this.hero = hero1;
   }

   //constructor
   public Combat(Hero hero1)
   {
      this.hero = hero1;
   }
}

public class Main
{
    public static void main(String args[])
    {

      Hero hero1 = new Hero();

      //passing hero to Combat
      Combat combat = new Combat(hero1);
      //or 
      combat.setHero(hero1);
    }
}