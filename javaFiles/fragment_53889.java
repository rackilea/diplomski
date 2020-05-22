public class DynamicSetTest {

    private Animal animal1 = null;
    private Animal animal2 = null;
    private Animal animal3 = null;

    public Animal getAnimal1() {
        return animal1;
    }
    public Animal getAnimal2() {
        return animal2;
    }
    public Animal getAnimal3() {
        return animal3;
    }

    public void setField(String name, Animal value) throws Exception {
            Field field = this.getClass().getDeclaredField(name);
            field.set(this, value);
    }

    public static void main(String[] args) throws Exception {
        DynamicSetTest t = new DynamicSetTest();
        Animal anAnimal = new Animal();
        t.setField("animal3", anAnimal);
        assert t.getAnimal3() == anAnimal;
    }
}