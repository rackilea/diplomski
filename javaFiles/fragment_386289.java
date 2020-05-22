public class FET {

    public static void main(String[] args){

        Pokemon aerodactyl = new Pokemon (new Ability[]{ Ability.WALK, Ability.FLY  });
        Pokemon golduck    = new Pokemon (new Ability[]{ Ability.WALK, Ability.SWIM });

        System.out.println ("aerodactyl = " + aerodactyl);
        System.out.println ("golduck    = " + golduck   );
        System.out.println ();

        golduck.copy (aerodactyl);

        System.out.println ("aerodactyl = " + aerodactyl);
        System.out.println ("golduck    = " + golduck   );      // golduck has now the same abilities as aerodactyl
        System.out.println ();

        aerodactyl.abilities[0] = Ability.EXPLODE;              // change aerodactyl's abilities

        System.out.println ("aerodactyl = " + aerodactyl);
        System.out.println ("golduck    = " + golduck   );      // abilities of aerodactyl have changed but golduck's not
        System.out.println ();

    }

}

enum Ability {
    WALK,
    FLY,
    SWIM,
    TALK,
    EXPLODE
}

class Pokemon {

    public Ability[] abilities;

    public Pokemon (Ability[] abilities) {              // constructor
        this.abilities = abilities;
    }

    public void copy (Pokemon p) {                      // copy abilities of another Pokemon
        abilities = (Ability[]) p.abilities.clone();
    }

    public String toString() {                          // string representation of Pokemon
        String str = "Pokemon";
        if (abilities != null) {
            for(int i = 0; i < abilities.length; i++) {
                str += (i==0) ? ": " : ", ";
                str += abilities[i];
            }
        }
        return str;
    }

}