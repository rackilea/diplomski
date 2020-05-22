class Attributes {}

class Base extends Attributes {
    int strength;
}

class Vampire extends Base {
    int fangLength;
}

class Player<A extends Attributes> {
    final A attributes;
    final List<Trait<? super A>> traits = new ArrayList<>();

    Player(A attributes) {
        this.attributes = attributes;
    }

    void applyTraits() {
        for(Trait<? super A> t : traits)
            t.apply(this);
    }
}

interface Trait<A extends Attributes> {
    void apply(Player<? extends A> player);
}

class StrengthTrait implements Trait<Base> {
    @Override
    public void apply(Player<? extends Base> player) {
        player.attributes.strength = 1000;
    }
}

class FangLengthTrait implements Trait<Vampire> {
    @Override
    public void apply(Player<? extends Vampire> player) {
        player.attributes.fangLength = 100;
    }
}

final class Factory {
    private Factory() {}

    public static Player<Base> newPlayer() {
        return new Player<Base>(new Base());
    }

    public static Player<Vampire> newVampire() {
        return new Player<Vampire>(new Vampire());
    }
}