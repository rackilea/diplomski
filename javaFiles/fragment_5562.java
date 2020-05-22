public abstract class Animal<A extends Cage<C, A>, C extends Animal<A, C>> {

    private A cage;

    public A getCage() {
        return this.cage;
    }

    public void setCage(final A cage) {
        this.cage = cage;
    }

}

public abstract class Cage<A extends Animal<C, A>, C extends Cage<A, C>> {

    private List<A> animals;

    @SuppressWarnings("unchecked")
    public void addAnimal(final A animal) {
        if (animal != null) {
            animal.setCage((C) this);
            if (this.animals == null) {
                this.animals = new ArrayList<A>();
            }
            this.animals.add(animal);
        }
    }

}