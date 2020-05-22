import java.util.*;
import java.util.stream.*;
import java.awt.Point;

public class JunkCollections{
    public static void main(String[] args){
        String[][] grid = {
            { "one", "two", "three"},
            {"four", "five", "six"}
        };
        List<String> strings = Arrays.stream( grid ).flatMap( s -> Arrays.stream(s)).collect(Collectors.toList());
        Map<Point, String> mapped = new HashMap<>();
        for(int i = 0; i<2; i++){
            for(int j = 0; j<3; j++){
                mapped.put(new Point(i,j), grid[i][j]);
            }
        }

        for(int i = 0; i<2; i++){
            for(int j = 0; j<3; j++){
                System.out.print(mapped.get(new Point(i,j)) + " ");
            }
            System.out.println();
        }
    }
}