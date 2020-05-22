public class Generator {
private static int row = 5;
private static int col = 5;
private static String[][] grid = new String[row][col];

static {
   grid[1][1] = "S";
}

public static void Grid_Generator() {

   String AB = "_W";

   SecureRandom rnd = new SecureRandom();
   for (int i = 0; i < grid.length; i++) {
       StringBuilder sb = new StringBuilder(row);
       for (int j = 0; j < grid[i].length; j++) {
           sb.append(AB.charAt(rnd.nextInt(AB.length())));
           grid[i][j] = sb.toString();
       }
   }
}