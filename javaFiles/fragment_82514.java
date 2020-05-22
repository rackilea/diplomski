class Item {

    public Item(String name, double weight) {

    }
}

public class Equippable extends Item {

    double mDurability;

    public Equippable(String name, double weight, double durability) {
        super(name, weight);
        mDurability = durability;
    }

    //Getters
    public double getDurability() {
        return mDurability;
    }

    //Setters
    public void setDurability(double Durability) {
        mDurability = Durability;
    }
}

class BodyPart {

    String name;
    Class<? extends Equippable> equipClass;

    public BodyPart(String name, Class<? extends Equippable> equipClass) {
        this.name = name;
        this.equipClass = equipClass;
    }
}

public class Armor extends Equippable {

    double mArmorRating;

    public Armor(String name, double weight, double durability, double armorrating) {
        super(name, weight, durability);
        mArmorRating = armorrating;
    }
}

public class HumanoidBodyArmor extends Armor {

    public HumanoidBodyArmor(String name, double weight, double durability, double armorrating) {
        super(name, weight, durability, armorrating);
    }
}

public void test() {
    BodyPart head = new BodyPart("Head", Armor.class);
    BodyPart body = new BodyPart("Body", HumanoidBodyArmor.class);
}