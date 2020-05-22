public abstract class AbstractFactory<T> {
    public abstract List<T> getData();
}

public class HumanFactory extends AbstractFactory<Human>{

    @Override
    public List<Human> getData() {
        return new ArrayList<>(); // Or what ever data you need it filled with
    }

}

public class AnimalFactory extends AbstractFactory<Animal>{

    @Override
    public List<Animal> getData() {
        return new ArrayList<>(); // Or what ever data you need it filled with
    }

}