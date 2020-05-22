import java.util.EnumMap;

public class Program {

    enum Importance {
    Low, Medium, High, Critical
    }

    public static void main(String[] args) {

    // Create an EnumMap.
    EnumMap<Importance, String> e = new EnumMap<>(Importance.class);
    e.put(Importance.Low, "=Low");
    e.put(Importance.High, "=High");

    // Get values from the map.
    String value1 = e.get(Importance.Low);
    String value2 = e.get(Importance.High);

    System.out.println(value1);
    System.out.println(value2);
    }
}