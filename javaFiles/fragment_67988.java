//!! public class Dobbelsteen extends Spel {
public class Dobbelsteen { //!!

   int dobbelsteen;
   int nieuwepositie;
   int nieuwepositie2;
   public static String newPos;
   public static String newPos2;
   int oudepositie;
   int oudepositie2;
   int huidigepositie = Spel.positie;
   // int huidigepositie2 = Spel.positie2;
   int aantalOgen = Spel.aantalogen;
   int aantalOgen2 = Spel.aantalogen2;
   static boolean heeftgewonnen = false;

   // !! Spel spiel = new Spel();
   Spel spiel; // !!

   // !!
   public Dobbelsteen(Spel spiel) {
      this.spiel = spiel;
   }

   public void aantalOgen(int aantalogen) {
      oudepositie = huidigepositie;
      nieuwepositie = (huidigepositie + aantalOgen);
      if (nieuwepositie == Spel.eindronde) { //!!
         System.out.println("Speler Piet heeft de ronde gewonnen!");
         spiel.updateUI(); //!! ****** here in particular ******
      } else if (nieuwepositie > Spel.eindronde) {
         Spel.positie = huidigepositie; //!!
         spiel.output.setText("Je hebt teveel gegooid"); //!!
         spiel.output.setForeground(Color.red); //!!
      } else {
         Spel.oudpositie = oudepositie; //!!
         Spel.positie = nieuwepositie; //!!
         newPos = String.valueOf(nieuwepositie);
         if (SpelHost.host) {
            SpelHost.verstuurPositie("Positie" + newPos);
         } else if (SpelClient.client) {
            SpelClient.verstuurPositie("Positie" + newPos);
         }
      }

   }
}