public class Dto {
    private final Integer id;
    private final String name;

    public Dto(Pet pet) {
        this.id= pet.getId();
        this.name= pet.getName();
    }
}