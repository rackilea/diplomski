import java.util.Scanner;

public class Example{
    public static void main(String[] args) {
        //starting player position
        int px = 4;
        int py = 2;
        String player = "P";

        String map[][] = new String[5][5];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]="0";
            }
        }

        for(int i = 0; i < map.length; i++) 
            for (int j = 0; j < map.length; j++) {

                map[px][py] = player;

                //System.out.println(map[i][j]);
                System.out.println("1-move up \n2-move right \n3-move left\n4-move- down");
                int move;
                Scanner scanner = new Scanner(System.in);
                move = scanner.nextInt();

                //up
                if(move == 1) {
                    map[px][py] = "0";
                    map[--px][py] = player;
                    printMap(map);
                }

                //right
                if(move == 2) {
                    map[px][py] = "0";
                    map[px][++py] = player;
                    printMap(map);
                }

                //left
                if(move == 3) {
                    map[px][py] = "0";
                    map[px ][--py] = player;
                    printMap(map);
                }

                //down
                if(move == 4) {
                    map[px][py] = "0";
                    map[++px][py] = player;
                    printMap(map);
                }


            }

    }
    public static void printMap(String[][] a) {
        for ( int i = 0; i < a.length; i++) 
        {
            for( int j = 0; j < a[1].length; j++) 
                System.out.print( a[i][j]+" ");         
          System.out.println();
        }
   }
}