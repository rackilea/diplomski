import java.io.*;

public class Read2DArray {
    private final int WIDTH = 28;
    private final int HEIGHT = 31;

    private char[][] maze = new char[WIDTH][HEIGHT];

    public static void main(String[] args) {
        Read2DArray array = new Read2DArray();
        array.loadFile("maze.txt");
        array.printArray();
    }

    public void loadFile(String fname) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fname));

            String line;
            int col = 0, row = 0;
            while((line = reader.readLine()) != null && row < HEIGHT) {
                for(col = 0; col < line.length() && col < WIDTH; col++) {
                    maze[col][row] = line.charAt(col);
                }
                row++;
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void printArray() {
        for(int row = 0; row < HEIGHT; row++) {
            for(int col = 0; col < WIDTH; col++) {
                System.out.print(maze[col][row]);
            }
            System.out.println();
        }
    }
}