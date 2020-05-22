@XmlRootElement(name="person")
public class PersonConfig {

    private AnimalConfig animalConfig;

    @XmlElementRefs({
        @XmlElementRef(name="cat", type=CatConfig.class),
        @XmlElementRef(name="dog", type=DogConfig.class)
    })
    public AnimalConfig getAnimalConfig() {
        return animalConfig;
    }

    public void setAnimalConfig(AnimalConfig animalConfig) {
        this.animalConfig = animalConfig;
    }
}