import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Building implements Comparable<Building> {
    final int height, totalArea;
    final String name;

    Building(int height, int totalArea, String name) {
        this.height = height;
        this.totalArea = totalArea;
        this.name = name;
    }

    public int compareTo(Building o) {
        if (height < o.height) return -1;
        if (height == o.height) return 0;
        return 1;
    }

    @Override
    public String toString() {
        return "Building{" +
                "height=" + height +
                ", totalArea=" + totalArea +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        List<Building> buildings = Arrays.asList(
                new Building(100, 5000, "Medium"),
                new Building(250, 3000, "Very tall"),
                new Building(50, 4000, "Short"),
                new Building(150, 3500, "Tall")
                );
        // sort as defined by Object itself -- by height
        Collections.sort(buildings);
        System.out.println(buildings);

        // sort by providing explicit order criteria -- total area
        Collections.sort(buildings, new Comparator<Building>() {
            public int compare(Building o1, Building o2) {
                if (o1.totalArea < o2.totalArea) return -1;
                if (o1.totalArea == o2.totalArea) return 0;
                return 1;
            }
        });
        System.out.println(buildings);
    }
}