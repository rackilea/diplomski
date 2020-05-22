public class Manager implements IManager {
    private final PersonInterface person;

    @Inject
    public Manager(@Assisted PersonInterface person) {
        this.person = person;
    }

    @Override
    public String getPersonName() {
        return person.getName();
    }

}