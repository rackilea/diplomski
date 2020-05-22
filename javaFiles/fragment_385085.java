class Heroes {

    public static Attributes getSlardar() {

        Attributes  slardar = new Attributes();

        slardar.setName("Slardar");

        slardar.setHp(115);

        slardar.setDamage(14);

        slardar.setArmor(6);

        slardar.setIsAlive(true);

        return slardar;

    }

}

public class Main {
     public static void main(String[] args) {

        Attributes attribs = new Attributes();

        Heroes heroes = new Heroes();

        heroes.getSlardar().displayAttributes();

    }

}