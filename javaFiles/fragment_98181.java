import java.lang.reflect.Constructor;

public class TestClass {
    public static void main(String[] args) {
        Entry entry = (Entry)Entry.getOrCreate("entry", Entry.class);
        SubEntry subEntry = (SubEntry)SubEntry.getOrCreate("subEntry", SubEntry.class);

        System.out.println("entry class: " + entry.getClass().getName());
        System.out.println("subEntry class: " + subEntry.getClass().getName());
    }
}

class Entry {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Object getOrCreate(String name, Class clazz) {
        // If a constructor is created that takes a String, such as "public Entry(String name)",
        // then each sub class will need to implement that method. Instead I used a getter and
        // setter for the name attribute.
        try {
            Entry entry = (Entry)clazz.newInstance();
            entry.setName(name);
            return entry;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class SubEntry extends Entry {
}