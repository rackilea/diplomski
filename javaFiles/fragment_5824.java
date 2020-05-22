public class BaseClass<TAnimal extends Animal>
{
    private TAnimal animal;

    public BaseClass(TAnimal animal)
    {
        this.animal = animal;
    }

    public TAnimal getAnimal()
    {
        return animal;
    }
}