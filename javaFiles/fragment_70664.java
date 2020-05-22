import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class TilesExample {

    public static void main(String [] args) {

        Tile t1 = new Tile("red", 7);
        Tile t2 = new Tile("red", 2);
        Tile t3 = new Tile("blue", 9);
        Tile t4 = new Tile("white", 17);
        Tile t5 = new Tile("blue", 3);
        Tile t6 = new Tile("red", 15);
        Tile t7 = new Tile("white", 10);
        List<Tile> tilesList = Arrays.asList(t1, t2, t3, t4, t5, t6, t7);

        System.out.println(getTilesWithColor1(tilesList, "red"));
        System.out.println(getTilesWithColor2(tilesList, "red"));

        System.out.println(getTileColorsAndValues(tilesList));

        System.out.println(getTilesByColorsAndValues(tilesList));
    }

    private static Map<String, List<Tile>> getTilesByColorsAndValues(List<Tile> tilesList) {
        return tilesList.stream()
                        .collect(Collectors.groupingBy(Tile::getColour));
    }

    private static Map<String, List<Integer>> getTileColorsAndValues(List<Tile> tilesList) {
        return tilesList.stream()
                        .collect(Collectors.groupingBy(Tile::getColour,
                            Collectors.mapping(Tile::getValue, Collectors.toList())));
    }

    private static List<Tile> getTilesWithColor1(List<Tile> tilesList, String searchColor) {
        return tilesList.stream()
                         .filter(tile -> tile.getColour().equals(searchColor))
                         .collect(Collectors.toList());
    }

    private static List<Tile> getTilesWithColor2(List<Tile> tilesList, String searchColor) {
        List<Tile> result = new ArrayList<>();
        for (Tile t : tilesList) {
            if (t.getColour().equals(searchColor)) {
                result.add(t);
            }
        }
        return result;
    }
}