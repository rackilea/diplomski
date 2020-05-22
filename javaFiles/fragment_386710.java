class PlayerCharacter<P extends PlayerCharacter<P>> {
    List<Trait<? super P>> myTraits;
}

class VampirePlayer extends PlayerCharacter<VampirePlayer> {...}

abstract class Trait<P extends PlayerCharacter<P>> {
    abstract void apply(P player);
}

class FangLengthTrait extends Trait<VampirePlayer> {...}