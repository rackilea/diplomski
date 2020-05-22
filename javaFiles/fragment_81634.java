public abstract class Hero extends GameCharacter {
    public abstract void test();
}

public class Hero1 extends Hero {
    @Override
    public void test() {}
}

...

List<Hero> heroes  = ... ;
heroes.add(new Hero1());
for (Hero h : heroes) { h.test(); }