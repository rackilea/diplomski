public interface Named {
    public String getName();
}

public class SpecialClass implements Named {
    private String name;

    public SpecialClass(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

public enum SpecialEnum implements Named {
    FIRST("First"), SECOND("Second");

    private String name;

    SpecialEnum(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

public void displayName(Named specialClass) {
    System.out.println(specialClass.getName());
}